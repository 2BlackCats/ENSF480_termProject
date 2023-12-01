package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import entity.Airline;
import entity.Seat;

public class UpdateDB {

	private ResultSet results;
	private Connection dbConnect;

	public UpdateDB () {

		createConnection();
		try {
			update();
		}
		catch (SQLException e) {
			System.out.println("Problem updating db");
            e.printStackTrace();
		}
		closeConnection();

	}

	public Airline filledAirline() {
		return Airline.getAirline();
	}

	public void createConnection() {
		try {
			dbConnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/air_travel", "root", "");
		}
		catch (SQLException e) {
			System.out.println("Problem establishing connection");
            e.printStackTrace();
		}
	}

	public void closeConnection() {
        try {
            results.close();
            dbConnect.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void update() throws SQLException{
		updateUsers();
		updateFlights();
		updateAircrafts();
		updateSeats();
	}

	public void updateUsers() throws SQLException {
		String update = "TRUNCATE TABLE Login" ;
		Statement st = dbConnect.createStatement();
		st.executeUpdate(update);

		for (int i =0; i < filledAirline().getListOfUsers().size(); i++){
			String query = "insert into login (Username, Password, Email, Type)";
			PreparedStatement ps = dbConnect.prepareStatement(query);
			ps.setString(1, filledAirline().getListOfUsers().get(i).getUsername());
			ps.setString(2, filledAirline().getListOfUsers().get(i).getPassword());
			ps.setString(3, filledAirline().getListOfUsers().get(i).getEmail());
			ps.setString(4, filledAirline().getListOfUsers().get(i).getPriviledge());

		}		

	}

	public void updateFlights() throws SQLException {
		String update = "TRUNCATE TABLE Flight";
		Statement st = dbConnect.createStatement();
		st.executeUpdate(update);

		for (int i =0; i < filledAirline().getListOfFlights().size(); i++){
			String query = "insert into flight (ID, Origin, Destination, Date, Aircraft_ID)";
			PreparedStatement ps = dbConnect.prepareStatement(query);
			ps.setInt(1, filledAirline().getListOfFlights().get(i).getID());
			ps.setString(2, filledAirline().getListOfFlights().get(i).getOrigin());
			ps.setString(2, filledAirline().getListOfFlights().get(i).getDestination());
			ps.setObject(3, filledAirline().getListOfFlights().get(i).getFlightDate());
			ps.setInt(4,filledAirline().getListOfAircrafts().get(i).getID());
		}


	}

	public void updateAircrafts() throws SQLException{
		String update = "TRUNCATE TABLE Aircrafts";
		Statement st = dbConnect.createStatement();
		st.executeUpdate(update);

		for (int i =0; i < filledAirline().getListOfAircrafts().size(); i++){
			String query = "insert into Aircrafts (ID, size)";
			PreparedStatement ps = dbConnect.prepareStatement(query);
			ps.setInt(1, filledAirline().getListOfAircrafts().get(i).getID());
			ps.setString(2, filledAirline().getListOfAircrafts().get(i).getSize());
		}


	}

	public void updateSeats() throws SQLException{
		int craftCount = filledAirline().getListOfAircrafts().size();
		for (int i = 0; i < craftCount; i++){
			Seat[][] currSeatMap = filledAirline().getListOfAircrafts().get(i).getSeatMap();
			if (filledAirline().getListOfAircrafts().get(i).used() == true){
				//update
				for (Seat[] seatRow : currSeatMap) {
					for (Seat curSeat: seatRow) {
						if (curSeat.reservedSeat()) {
							String seatPassengerName = curSeat.reservedFor().getUsername();
							String update = "UPDATE Seats SET Passenger_Name = '" + seatPassengerName + "' WHERE Aircraft_ID = " + filledAirline().getListOfAircrafts().get(i).getID();
							Statement st= dbConnect.createStatement();
							st.executeUpdate(update);
						}
					}
				}
			}
		}
	}
}