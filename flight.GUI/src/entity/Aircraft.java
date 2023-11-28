package entity;

public abstract class Aircraft {
	protected int id;
	protected String size;
	private boolean used;
	protected Seat[][] seatMap;
	
	public Seat[][] getSeatMap(){
		return seatMap;
	}
	
	public int getID() {
		return id;
	}
	
	public String getSize() {
		return size;
	}
	
	public void reserveSeat(int row, int column, User customer) {
		seatMap[row][column].reserveSeat(customer);
	}
	
	public boolean used() {
		return used;
	}
	
	public void changeUsed() {
		used = !used;
	}
}
