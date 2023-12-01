package flight.GUI;

import java.awt.EventQueue;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Aircraft;
import entity.Airline;
import entity.Flight;
import entity.Seat;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment extends JPanel{
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	

	/**
	 * Create the application.
	 * 
	 *
	 */


public String[][] seatDisplay(String ID,Seat[][] seatList ) {
	String availabilty;
	String[][] seatDisplay = new String[seatList.length][seatList[0].length];
	for (int i = 0; i < seatList.length; i++) {
		for (int j = 0; j < seatList[i].length; j++) {
				String type = seatList[i][j].getSeatType();
				boolean reserved = seatList[i][j].reservedSeat();
				if (reserved) {
					availabilty = "Booked";
		
				}
				else { 
					availabilty = "Free";
				}

				seatDisplay[i][j] = ((char)(i+65) + Integer.toString(j));
		}}
	return seatDisplay;

}


	public Payment(JFrame main, String user,Aircraft airPlane,String ID){
		
		 
		 Seat[][] seatList = airPlane.getSeatMap();
		 String[][] seatAvailability = new String[seatList.length][seatList[0].length];
		 String[][] seatDisplay = new String[seatList.length][seatList[0].length];
		 String[][] seatType = new String[seatList.length][seatList[0].length];
		 for (int i = 0; i < seatList.length; i++) {
			for (int j = 0; j < seatList[i].length; j++) {
				seatDisplay[i][j] = ((char)(i+65) + Integer.toString(j));
				String type = seatList[i][j].getSeatType();	
				seatType [i][j] = type;
				boolean reserved = seatList[i][j].reservedSeat();
				if (reserved) {
					String availability = "Booked";
                    seatAvailability[i][j] = availability;
						}
				else { 
					String availability = "Free";
                    seatAvailability[i][j] = availability;
						}
				}
			}
		 String[] header = new String[seatList[0].length];
		 for (int i = 0; i < header.length; i++) {
			 header[i] = "";
 		 }
		 setLayout(null);
		 
		 JTextField seat= new JTextField();
		 seat.setBounds(89, 79, 130, 26);
		 add(seat);
		 seat.setColumns(10);
		 JTable seatView = new JTable(seatDisplay,header);
		 seatView.setBounds(6, 6, 438, 62);
		 seatView.setEnabled(false);
		 add(seatView);
		 
		 JLabel select = new JLabel("Select Seat");
		 select.setBounds(16, 84, 90, 16);
		 add(select);
		 
		 JButton btnNewButton = new JButton("Confirm");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		String seatNum = seat.getText();
		 		Seat[][] seatList = airPlane.getSeatMap();
				String[][] seatDisplay = new String[seatList.length][seatList[0].length];
				for (int i = 0; i < seatList.length; i++) {
					for (int j = 0; j < seatList[i].length; j++) {
						seatDisplay[i][j] = ((char)(i+65) + Integer.toString(j));
						if(seatDisplay[i][j].equals(seatNum)){
							String type = seatList[i][j].getSeatType();	
							boolean reserved = seatList[i][j].reservedSeat();
							if (reserved) {
								String availability = "Booked";
			                    
									}
							else { 
								String availability = "Free";
			                   
									}
							
							 
								    
								}
						}}
				
					}
		 		    
		 });
		 btnNewButton.setBounds(231, 80, 117, 29);
		 add(btnNewButton);
		 
		 
	
		 ////Different functions for each
		 
		 
		 	
	}
		
}



		    



			
			
		
