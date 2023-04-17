package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Flights")
public class Flight {

	@Id
	private String flightid;
	private String flightName;
	private String departure;
	private String arrival;

	public Flight() {

	}

	public Flight(String flightid, String flightName, String departure, String arrival) {
		super();
		this.flightid = flightid;
		this.flightName = flightName;
		this.departure = departure;
		this.arrival = arrival;
		

	}

	public String getFlightid() {
		return flightid;
	}

	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

}
