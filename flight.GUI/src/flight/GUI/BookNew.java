package flight.GUI; 
import javax.swing.JPanel;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JTextField;

import entity.Airline;
import entity.Flight;
import entity.Seat;

import javax.swing.JButton;

public class BookNew extends JPanel {
	private JTextField search;
	private JTable table;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 * 
	 * 
	 */
	
	//ArrayList<Flight> allFlight = Air
	
	public String[][] flightArrayToString(ArrayList<Flight> array){
		String[][] stringArray = new String[array.size()][4];
		for (int i = 0; i < array.size(); i++) {
			stringArray[i][0]=	Integer.toString(array.get(i).getID());
			stringArray[i][1]=	array.get(i).getDestination();
			stringArray[i][2]=	array.get(i).getFlightDate().format(DateTimeFormatter.ISO_DATE_TIME);
			}
		return stringArray;
	

	}
	
	public BookNew(JFrame main, String user) {
		setLayout(null);
		
		search = new JTextField();
		search.setBounds(257, 4, 130, 35);
		add(search);
		search.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Flights");
		btnNewButton.setBounds(257, 51, 129, 25);
		add(btnNewButton);
		
		//String[][] listFlight= flightArrayToString(Airline.getAirline().getListOfFlights());
	
		String[] Titles= {"ID","Destination","Local Date","Select"};
		//JTable display = new JTable();
	//	display.setBounds(22, 6, 223, 273);
//		add(display);
//	
		
		textField_1 = new JTextField();
		textField_1.setBounds(257, 79, 130, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton1 = new JButton("Select Flight");
		btnNewButton1.setBounds(256, 126, 130, 35);
		add(btnNewButton1);
		
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				String ID = textField_1.getText();
//				Seat[][] seatMap = .getPlane().getSeatMap();
//				for (int i = 0; i < seatMap.length; i++) {
//					for (int j = 0; j < seatMap[i].length; j++) {
//						if (seatMap[i][j] != null) 

			
				
				
			}
			
		});
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				String destination = search.getText();
				
				String[][] listSearchedFlight= flightArrayToString(Airline.getAirline().findFlights(destination));
				JTable display = new JTable(listSearchedFlight,Titles);      
				display.setBounds(22, 6, 223, 273);
				add(display);
				main.revalidate();
				
				
				
			}
			
		});
		
	}
}
