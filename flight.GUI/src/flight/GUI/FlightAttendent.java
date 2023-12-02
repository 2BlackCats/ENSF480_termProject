package flight.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JButton;

import entity.Aircraft;
import entity.Airline;
import entity.Flight;
import entity.Seat;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class FlightAttendent extends JPanel{
	private JButton btnNewButton;
	private JSplitPane splitPane;
	private JTable flightTable;
	private JTable seatTable;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the application.
	 */
	public String[][] seatDisplay(String ID){
		  ArrayList<Flight> flightList = Airline.getAirline().getListOfFlights();
		  String [][] flightDetails = new String[flightList.size()][2];
		  for (int i = 0; i < flightList.size() && (Integer.toString(flightList.get(i).getID()).equals(ID)); i++) {
			  if (flightList.get(i).getPlane().getSeatMap() != null) {
				  Seat [][] seatList = flightList.get(i).getPlane().getSeatMap();
				  for (int k = 0; k < seatList.length; k++) {
					  for (int j = 0; j < seatList[k].length; j++) {
						  if(seatList[k][j].reservedFor()!= null) { 
								  flightDetails[i][0] = ((char)(i+65) + Integer.toString(j));
								  flightDetails[i][1] = (seatList[k][j].reservedFor().getUsername());
					  			}
					  		}
			  
			  			}
			  }

		  }
		  return flightDetails;
		
	}

	
	public FlightAttendent(JFrame main, String user, Airline al) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Flight ID:");
		lblNewLabel.setBounds(6, 16, 103, 16);
		add(lblNewLabel);
		
		JTextField flightText = new JTextField();
		flightText.setBounds(107, 11, 130, 26);
		add(flightText);
		flightText.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("View Passengers");
		btnNewButton_1.setBounds(267, 11, 147, 29);
		add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				String ID = flightText.getText();
				String[][] passengerList = seatDisplay(ID);
				String[] Titles= {"SeatNum","Name"};
				JTable passengerView = new JTable(passengerList,Titles);
				passengerView.setBounds(18, 64, 398, 180);
				add(passengerView);
				
			}
		});
				
	
	}

	
	

}
