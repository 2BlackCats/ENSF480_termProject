package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import entity.*;

public class ReadDB {

	private ResultSet results;
	private Connection dbConnect;

	public ReadDB () {

		createConnection();
		try {
			loadFromDB();
		}
		catch (SQLException e) {
			System.out.println("Problem Loading from db");
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

	public void loadFromDB() throws SQLException {
		populateUsers();
		populateAircrafts();
		populateFlights();
		for (Aircraft craft : filledAirline().getListOfAircrafts()){
			populateSeats(craft.getID());
		}
	}

	public void populateUsers() throws SQLException {
		Statement st = dbConnect.createStatement();
		String query = "SELECT * FROM air_travel.login;";
		results = st.executeQuery(query);
		while(results.next()){
			
			if (results.getString("Type").compareTo("Member") == 0) {
				
				filledAirline().addUser(results.getString("Username"), results.getString("Password"), results.getString("Email"), results.getString("Type"));
			}
			else if (results.getString("Type").compareTo("Agent") == 0) {
				
				filledAirline().addAgent(results.getString("Username"), results.getString("Password"), results.getString("Email"), results.getString("Type"));
			}
			else if (results.getString("Type").compareTo("Admin") == 0) {
				
				filledAirline().addAdmin(results.getString("Username"), results.getString("Password"), results.getString("Email"), results.getString("Type"));
			}
		}
		
	}

	public void populateAircrafts() throws SQLException {
		Statement st = dbConnect.createStatement();
		String query = "select * from Aircrafts";
		results = st.executeQuery(query);
		while (results.next()) {
			filledAirline().addAircraft(results.getString("Size"), results.getInt("ID"));

		}

	}

	public void populateFlights() throws SQLException {
		Statement st = dbConnect.createStatement();
		String query = "select * from Flight";
		results = st.executeQuery(query);

		while(results.next()){
			for(int i =0; i < filledAirline().getListOfAircrafts().size(); i++){
				if (filledAirline().getListOfAircrafts().get(i).getID() == results.getInt("Aircraft_ID")) {
					filledAirline().addFlight(results.getInt("ID"),results.getString("Destination"), results.getTimestamp("Time").toLocalDateTime(), Airline.getAirline().getListOfAircrafts().get(i));
					break;
				}

			}

		}

	}

	public void populateSeats(int AircraftID) throws SQLException {
		for(int i =0; i < filledAirline().getListOfAircrafts().size(); i++){

			if(filledAirline().getListOfAircrafts().get(i).getID() == AircraftID){

				Statement st = dbConnect.createStatement();
				String query = "select * from Seats where 'Passenger_name' != null AND Aircraft_ID = " + String.valueOf(AircraftID);		
				results = st.executeQuery(query);

				while(results.next()){
					String customer = results.getString("Passenger_Name");
					for(User checkUser : filledAirline().getListOfUsers()) {
						if (checkUser.getUsername() == customer) {
							filledAirline().getListOfAircrafts().get(i).reserveSeat(results.getInt("Seat_Row"), results.getInt("Seat_Column"), checkUser);
						}
					}
				}
			}	
		}
	}


}