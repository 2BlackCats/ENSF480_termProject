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

public class Payment2 extends JPanel{


	/**
	 * Create the application.
	 * 
	 *
	 */


	public Payment2(JFrame main, String user, Airline al){
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thank you!! Payment Successful");
		lblNewLabel.setBounds(6, 6, 207, 37);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Home Page");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Customer(main, user, al));
				main.revalidate();
			
			}
			
			});
		btnNewButton.setBounds(6, 54, 117, 29);
		add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("Sign out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Login(main, al));				
				main.revalidate();
			}
			});
		btnNewButton_1.setBounds(6, 95, 117, 29);
		add(btnNewButton_1);
		
		 

		
}
}