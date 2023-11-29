package entity;

public abstract class Aircraft {
	protected int id;
	protected String size;
	private boolean used;
	protected Seat[][] seatMap;
	
	public Seat[][] getSeatMap(){
		System.out.println("aa");
		return seatMap;
	}
	
	public int getID() {
		return id;
	}
	
	public String getSize() {
		return size;
	}
	
 
	
	public boolean used() {
		return used;
	}
	
	public void changeUsed() {
		used = !used;
	}
}
