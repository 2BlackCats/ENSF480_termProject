package entity;

public class Seat {
	private String seatType;
	private User reservedPerson;
	
	public Seat(String seatType) {
		this.seatType = seatType;
	}
	
	public boolean reservedSeat() {
		if (reservedPerson == null) {
			return false;
		}
		return true;
	}
	
	public User reservedFor() {
		return reservedPerson;
	}
	
	public boolean reserveSeat(User customer) {
		if (reservedSeat()) {
			return false;
		}
		this.reservedPerson = customer;
		return true;
	}
	
	public String getSeatType() {
		return seatType;
	}
}
