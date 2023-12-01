package entity;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Flight {
	private int ID;
	private String origin;
	private String destination;
	private LocalDateTime flightDate;
	private Aircraft plane;
	
	private Flight (int ID, String origin, String destination, LocalDateTime local, Aircraft plane) throws
	DateTimeException {
			this.ID = ID;
			this.origin = origin;
			this.destination = destination;
			this.flightDate = local;
			this.plane = plane;
			plane.changeUsed();
	}
	
	static public Flight flightMaker(int id, String origin, String destination, LocalDateTime local, Aircraft plane) {
		Flight f;
		try {
			f = new Flight(id, origin, destination, local, plane);
		}
		catch (Exception DateTimeException) {
			return null;
		}
		return f;
	}

	public int getID(){
		return ID;
	}

	public void setID(int id){
		this.ID = id;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String dest) {
		this.destination = dest;
	}

	public String getOrigin() {
		return origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public LocalDateTime getFlightDate() {
		return flightDate;
	}
	
	public void setFlightDate(LocalDateTime local) {
		this.flightDate = local;
	}
	
	public Aircraft getPlane() {
		return plane;
	}
	
	public void setPlane(Aircraft plane) {
		this.plane = plane;
	}
	
	public boolean flightHappened() {
		if (flightDate.isAfter(LocalDateTime.now(ZoneId.of("MST")))) {
			return true;
		}
		return false;
	}
}
