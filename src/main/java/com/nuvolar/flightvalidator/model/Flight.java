package com.nuvolar.flightvalidator.model;

public class Flight {
    private String flightNumber;
    private String takeOffTime;
    private int numberOfPassengers;
    private double departureLatitude;
    private double departureLongitude;
    private double arrivalLatitude;
    private double arrivalLongitude;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getTakeOffTime() {
		return takeOffTime;
	}
	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public double getDepartureLatitude() {
		return departureLatitude;
	}
	public void setDepartureLatitude(double departureLatitude) {
		this.departureLatitude = departureLatitude;
	}
	public double getDepartureLongitude() {
		return departureLongitude;
	}
	public void setDepartureLongitude(double departureLongitude) {
		this.departureLongitude = departureLongitude;
	}
	public double getArrivalLatitude() {
		return arrivalLatitude;
	}
	public void setArrivalLatitude(double arrivalLatitude) {
		this.arrivalLatitude = arrivalLatitude;
	}
	public double getArrivalLongitude() {
		return arrivalLongitude;
	}
	public void setArrivalLongitude(double arrivalLongitude) {
		this.arrivalLongitude = arrivalLongitude;
	}
    
}
