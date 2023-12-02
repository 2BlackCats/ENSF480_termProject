package flight.GUI;
import javax.swing.JPanel;
import entity.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;

public class ViewExisting extends JPanel {
	private JFrame main;
	private JTable table;
	private String user;

	/**
	 * Create the panel.
	 */
	 
	public String[][] seatCurrent(String user){
		  ArrayList<Flight> flightList = Airline.getAirline().getListOfFlights();
		  String [][] flightDetails = new String[flightList.size()][4];
		  for (int i = 0; i < flightList.size(); i++) {
			  if (flightList.get(i).getPlane().getSeatMap() != null) {
				  Seat [][] seatList = flightList.get(i).getPlane().getSeatMap();
				  for (int k = 0; k < seatList.length; k++) {
					  for (int j = 0; j < seatList[k].length; j++) {
						  if(seatList[k][j].reservedFor() != null) {
						  if(seatList[k][j].reservedFor().getUsername().equals(user)) {
								  flightDetails[i][0] = user;
								  flightDetails[i][1] = Integer.toString(flightList.get(i).getID());
								  flightDetails[i][2] = flightList.get(i).getDestination();
								  flightDetails[i][3] = flightList.get(i).getFlightDate().format(DateTimeFormatter.BASIC_ISO_DATE);
						  			}}
					  }
					  			}
					  		}
			  
			  			}
		  return flightDetails;
			  }

		  
		  
	
	public ViewExisting(JFrame main, String user, Airline al) {
		this.main = main;
		this.user = user;
		setLayout(null);
		
		JButton returnButton = new JButton("Return");
		returnButton.setBounds(6, 126, 342, 29);
		add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Login(main, al));
				main.revalidate();
			}
		});
		
		String[][] flightDetails = seatCurrent(user);
		String[] Titles= {"ID","Destination","Local Date","Select"};
		table = new JTable(flightDetails,Titles);
		table.setBounds(6, 17, 396, 97);
		add(table);
		
		
		
		
		

	}

}
