package flight.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import entity.Airline;

public class SystemAdmin extends JPanel{

	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JButton btnNewButton;


	/**
	 * Create the application.
	 */
	public SystemAdmin(JFrame main, String user, Airline al) {
		setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		table = new JTable();
		tabbedPane.addTab("Flights", null, table, null);
		
		table_1 = new JTable();
		tabbedPane.addTab("Aircrafts", null, table_1, null);
		
		table_2 = new JTable();
		tabbedPane.addTab("Users", null, table_2, null);
		
		btnNewButton = new JButton("Log Off");
		add(btnNewButton, BorderLayout.SOUTH);
	}
}
