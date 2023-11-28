package entity;

public class LargeAircraft extends Aircraft{
	
	public LargeAircraft(int id) {
		this.id = id;
		size = "Large";
		seatMap = new Seat[3][5];
		for (int i = 0; i < seatMap.length; i++) {
			for (int j = 0; j < seatMap[i].length; j++) {
				if (i == 0) {
					seatMap[i][j] = new Seat("First");
				}
				else if (i == 1 || i == 2) {
					seatMap[i][j] = new Seat("Business");
				}
				else {
					seatMap[i][j] = new Seat("Economy");
				}
			}
		}
	}
}
