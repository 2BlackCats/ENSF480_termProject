package entity;

public class MediumAircraft extends Aircraft{

	public MediumAircraft(int id) {
		this.id = id;
		size = "Medium";
		seatMap = new Seat[3][3];
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
