package flight.GUI; 
import javax.swing.JPanel;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;

import javax.swing.JTextField;


import entity.*;

import javax.swing.JButton;

public class BookNew extends JPanel {
	private JTextField search;
	private JTable table;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	/**
	 * Create the panel.
	 * 
	 * 
	 */

	public Aircraft findAirCraft(String ID){
		  ArrayList<Aircraft> aircraftList = Airline.getAirline().getListOfAircrafts();
		  ArrayList<Flight> flightList = Airline.getAirline().getListOfFlights();
		  Integer aircraftID = 0;
		  for (int i = 0; i < flightList.size(); i++) {
			  
			  if(Integer.toString(flightList.get(i).getID()).equals(ID)) {
				   aircraftID = flightList.get(i).getPlane().getID();  
			  }}
		  
		
		  for (int i = 0; i < aircraftList.size(); i++) {
			  if(aircraftList.get(i).getID()==(aircraftID)) {
				  Aircraft airplane = aircraftList.get(i);
				  return airplane ;
				  
			  }
			  
		  }
		  return null;
		
		  
		  
		}
	    


	public String[][] flightArrayToString(ArrayList<Flight> array){
		String[][] stringArray = new String[array.size()][4];
		for (int i = 0; i < array.size(); i++) {
			stringArray[i][0]=	Integer.toString(array.get(i).getID());
			stringArray[i][1]=	array.get(i).getDestination();
			stringArray[i][2]=	array.get(i).getFlightDate().format(DateTimeFormatter.ISO_DATE_TIME);
			}
		return stringArray;
	

	}
	
	public BookNew(JFrame main, String user,  Airline al) {
		setLayout(null);
		
		search = new JTextField();
		search.setBounds(314, 6, 130, 35);
		add(search);
		search.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Flights");
		btnNewButton.setBounds(314, 53, 129, 25);
		add(btnNewButton);

		
		textField_1 = new JTextField();
		textField_1.setBounds(314, 79, 130, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton1 = new JButton("Select Flight");
		btnNewButton1.setBounds(314, 126, 130, 25);
		add(btnNewButton1);
		
		btnNewButton_1 = new JButton("Sign out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setContentPane(new Login(main, al));
				main.revalidate();
			}
		});
		btnNewButton_1.setBounds(314, 163, 130, 25);
		add(btnNewButton_1);
		
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				String ID = textField_1.getText();
				Aircraft airplane = findAirCraft(ID);
				main.setContentPane(new Payment(main ,user,airplane,ID,al));
				main.revalidate();
				
			}
			
		});
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				String destination = search.getText();
				String[] Titles= {"ID","Destination","Local Date","Select"};
				String[][] listSearchedFlight= flightArrayToString(Airline.getAirline().findFlights(destination));
				JTable display = new JTable(listSearchedFlight,Titles);      
				display.setBounds(22, 6, 223, 273);
				add(display);
				display.setEnabled(false);
				main.revalidate();
				
				
				
			}
			
		});
		
	}
}
