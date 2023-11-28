package entity;

import java.util.ArrayList;

public class SystemAdmin extends AirlineAgent{
	
	public SystemAdmin(String username, String password, String email, String priviledge) {
		super(username, password, email, priviledge);
	}
	
	public ArrayList<User> getUsers(){
		return Airline.getAirline().getListOfUsers();
	}
	
	public ArrayList<Aircraft> getAircrafts(){
		return Airline.getAirline().getListOfAircrafts();
	}
}
