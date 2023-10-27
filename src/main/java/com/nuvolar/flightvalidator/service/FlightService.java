package com.nuvolar.flightvalidator.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.nuvolar.flightvalidator.model.Flight;
import com.nuvolar.flightvalidator.util.Haversine;

@Service
public class FlightService {

    public String validateFlight(Flight flight) {
        double distance = haversine(flight.getDepartureLatitude(), flight.getDepartureLongitude(),
                flight.getArrivalLatitude(), flight.getArrivalLongitude());

        // RULE 1
        if (flight.getNumberOfPassengers() > 250 && distance > 8000) {
            return "Rule 1 violation: Flight with more than 250 passengers can't travel more than 8000km";
        } else if (distance > 12000) {
            return "Rule 1 violation: Maximum flight range exceeded";
        }

        // Parse takeOffTime
        LocalTime takeOff = LocalTime.parse(flight.getTakeOffTime());

        // RULE 2
        if (takeOff.isAfter(LocalTime.parse("20:00"))) {
            return "Rule 2 violation: No take-offs after 8:00 pm";
        } else if (takeOff.isAfter(LocalTime.parse("14:00")) && distance > 9000) {
            return "Rule 2 violation: Flights taking off after 2:00 pm can't travel more than 9000km";
        }

        // RULE 3 (assuming westward is a negative change in longitude)
        if (flight.getDepartureLongitude() > flight.getArrivalLongitude() &&
            (takeOff.isAfter(LocalTime.parse("15:00")) || distance > 3000)) {
            // Planes flying westward might have to deal with headwinds, which could slow down the flight.
            return "Rule 3 violation: Flights going West must take off before 3:00 pm and not travel further than 3000 km.";
        }

        return "Flight is feasible!";
    }

    public double haversine(double lat1, double lon1, double lat2, double lon2) {
    	return Haversine.getDistance(lat1, lon1, lat2, lon2);
    }

}
