package com.nuvolar.flightvalidator.controller;

import com.nuvolar.flightvalidator.model.Flight;
import com.nuvolar.flightvalidator.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/validateFlight")
    public ResponseEntity<String> validateFlight(@RequestBody Flight flight) {
    	
    	if (flight.getNumberOfPassengers() < 0) {
    	    return ResponseEntity.badRequest().body("Number of passengers cannot be negative.");
    	}
    	
        return ResponseEntity.ok(flightService.validateFlight(flight));
    }
}
