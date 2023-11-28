package entity;

import java.util.ArrayList;

public class AirlineAgent extends User{
	public AirlineAgent(String username, String password, String email, String priviledge) {
		super(username, password, email, priviledge);
	}
	
	public ArrayList<Flight> getFlights() {
		return Airline.getAirline().getListOfFlights();	
	}
}
