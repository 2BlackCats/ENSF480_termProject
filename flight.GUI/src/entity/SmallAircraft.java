package entity;

public class SmallAircraft extends Aircraft{

	public SmallAircraft(int id) {
		this.id = id;
		size = "Small";
		seatMap = new Seat[3][2];
		for (int i = 0; i < seatMap.length; i++) {
			for (int j = 0; j < seatMap[i].length; j++) {
				if (i == 0) {
					seatMap[i][j] = new Seat("First");
				}
				else if (i == 1) {
					seatMap[i][j] = new Seat("Business");
				}
				else {
					seatMap[i][j] = new Seat("Economy");
				}
			}
		}
	}
}
