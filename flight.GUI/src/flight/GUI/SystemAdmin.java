package flight.GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import entity.*;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class SystemAdmin extends JPanel{

	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	private JTabbedPane flightPane;
	private JPanel userModify;
	private JPanel userAdd;
	private JPanel flightModify;
	private JPanel flightAdd;
	private JPanel aircraftPane;
	private JTabbedPane userPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JComboBox comboBox;
	private JLabel lblNewLabel_3;
	private GridBagConstraints gbc_lblNewLabel_3;
	private DefaultTableModel flightModel;
	private DefaultTableModel aircraftModel;
	private DefaultTableModel userModel;
	private JLabel lblFlightId;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JTextField changePassword;
	private JLabel lblNewLabel_7;
	private JTextField changeEmail;
	private JLabel lblNewLabel_8;
	private JComboBox changeUserType;
	private JLabel lblNewLabel_10;
	private JTextField addUsername;
	private JLabel lblNewLabel_11;
	private JTextField addPassword;
	private JLabel lblNewLabel_12;
	private JTextField addEmail;
	private JLabel lblNewLabel_13;
	private JComboBox addUserType;
	private JButton addUserbtn;
	private JButton savePasswordbtn;
	private JButton saveEmailbtn;
	private JButton saveUserTypebtn;
	private JTextField textField_6;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_14;
	private JButton btnNewButton_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField changeDestination;
	private JButton saveDestinationbtn;
	private JLabel lblNewLabel_15;
	private JTextField changeDate;
	private JButton changeDatebtn;
	private JLabel lblNewLabel_16;
	private JTextField changeAircraft;
	private JButton changeAircraftbtn;
	
	private String username;
	private String flightID;
	private JLabel lblNewLabel_17;
	private JTextField removeAircraft;
	private JButton removeAircraftbtn;
	private JLabel lblNewLabel_18;

	/**
	 * Create the application.
	 */
	public SystemAdmin(JFrame main, String user, Airline al) {
		setLayout(new BorderLayout(0, 0));
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
	//Flight Code
		ArrayList<Flight> flightList = Airline.getAirline().getListOfFlights();
		String[] flightHeaders = {"Flight ID", "Destination", "Date: Time", "Aircraft ID"};
		String[][] flightArray = new String[flightList.size()][4];
		for (int i = 0; i < flightList.size(); i++) {
			flightArray[i][0] = Integer.toString(flightList.get(i).getID());
			flightArray[i][1] = flightList.get(i).getDestination();
			flightArray[i][2] = flightList.get(i).getFlightDate().format(DateTimeFormatter.ISO_DATE_TIME);
			flightArray[i][3] = Integer.toString(flightList.get(i).getPlane().getID());
		}
		flightModel = new DefaultTableModel(flightArray, flightHeaders);
		table = new JTable(flightModel);
		table.setEnabled(false);
		scrollPane = new JScrollPane(table);
		
		flightAdd = new JPanel();
		flightModify = new JPanel();
		
		flightPane = new JTabbedPane();
		flightPane.addTab("Add Flight", null, flightAdd, null);
		flightPane.addTab("Modify Flight", null, flightModify, null);
		
		GridBagLayout gbl_flightAdd = new GridBagLayout();
		gbl_flightAdd.columnWidths = new int[]{0, 0};
		gbl_flightAdd.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_flightAdd.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_flightAdd.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		flightAdd.setLayout(gbl_flightAdd);
		
		lblFlightId = new JLabel("Flight ID");
		GridBagConstraints gbc_lblFlightId = new GridBagConstraints();
		gbc_lblFlightId.insets = new Insets(0, 0, 5, 0);
		gbc_lblFlightId.gridx = 0;
		gbc_lblFlightId.gridy = 0;
		flightAdd.add(lblFlightId, gbc_lblFlightId);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 1;
		flightAdd.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Destination");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 2;
		flightAdd.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 0);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 0;
		gbc_textField_7.gridy = 3;
		flightAdd.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		lblNewLabel_9 = new JLabel("Date: Time (dd/mm/yyyy hh:mm)");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 4;
		flightAdd.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 0);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 0;
		gbc_textField_8.gridy = 5;
		flightAdd.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		lblNewLabel_14 = new JLabel("Aircraft ID");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 6;
		flightAdd.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 0;
		gbc_textField_9.gridy = 7;
		flightAdd.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		btnNewButton_6 = new JButton("Add Flight");
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 8;
		flightAdd.add(btnNewButton_6, gbc_btnNewButton_6);
		
		
		
		GridBagLayout gbl_flightModify = new GridBagLayout();
		gbl_flightModify.columnWidths = new int[]{0, 0};
		gbl_flightModify.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_flightModify.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_flightModify.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		flightModify.setLayout(gbl_flightModify);
		
		lblNewLabel_4 = new JLabel("Change Destination");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		flightModify.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		changeDestination = new JTextField();
		GridBagConstraints gbc_changeDestination = new GridBagConstraints();
		gbc_changeDestination.insets = new Insets(0, 0, 5, 0);
		gbc_changeDestination.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeDestination.gridx = 0;
		gbc_changeDestination.gridy = 1;
		flightModify.add(changeDestination, gbc_changeDestination);
		changeDestination.setColumns(10);
		
		saveDestinationbtn = new JButton("Save Destination");
		saveDestinationbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_saveDestinationbtn = new GridBagConstraints();
		gbc_saveDestinationbtn.insets = new Insets(0, 0, 5, 0);
		gbc_saveDestinationbtn.gridx = 0;
		gbc_saveDestinationbtn.gridy = 2;
		flightModify.add(saveDestinationbtn, gbc_saveDestinationbtn);
		
		lblNewLabel_15 = new JLabel("Change Date (dd/mm/yyyy hh:mm)");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 3;
		flightModify.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		changeDate = new JTextField();
		GridBagConstraints gbc_changeDate = new GridBagConstraints();
		gbc_changeDate.insets = new Insets(0, 0, 5, 0);
		gbc_changeDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeDate.gridx = 0;
		gbc_changeDate.gridy = 4;
		flightModify.add(changeDate, gbc_changeDate);
		changeDate.setColumns(10);
		
		changeDatebtn = new JButton("Save Date");
		GridBagConstraints gbc_changeDatebtn = new GridBagConstraints();
		gbc_changeDatebtn.insets = new Insets(0, 0, 5, 0);
		gbc_changeDatebtn.gridx = 0;
		gbc_changeDatebtn.gridy = 5;
		flightModify.add(changeDatebtn, gbc_changeDatebtn);
		
		lblNewLabel_16 = new JLabel("Change Aircraft");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 6;
		flightModify.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		changeAircraft = new JTextField();
		GridBagConstraints gbc_changeAircraft = new GridBagConstraints();
		gbc_changeAircraft.insets = new Insets(0, 0, 5, 0);
		gbc_changeAircraft.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeAircraft.gridx = 0;
		gbc_changeAircraft.gridy = 7;
		flightModify.add(changeAircraft, gbc_changeAircraft);
		changeAircraft.setColumns(10);
		
		changeAircraftbtn = new JButton("Save Aircraft");
		GridBagConstraints gbc_changeAircraftbtn = new GridBagConstraints();
		gbc_changeAircraftbtn.gridx = 0;
		gbc_changeAircraftbtn.gridy = 8;
		flightModify.add(changeAircraftbtn, gbc_changeAircraftbtn);
		
	//Aircraft Code
		ArrayList<Aircraft> aircraftList = Airline.getAirline().getListOfAircrafts();
		String[] aircraftHeaders = {"Aircraft ID", "Size"};
		String[][] aircraftArray = new String[aircraftList.size()][3];
		for (int i = 0; i < aircraftList.size(); i++) {
			aircraftArray[i][0] = Integer.toString(aircraftList.get(i).getID());
			aircraftArray[i][1] = aircraftList.get(i).getSize();
		}
		aircraftModel = new DefaultTableModel(aircraftArray, aircraftHeaders);
		table_1 = new JTable(aircraftModel);
		table_1.setEnabled(false);
		
		scrollPane_1 = new JScrollPane(table_1);
		aircraftPane = new JPanel();
		
		splitPane_1 = new JSplitPane(1, aircraftPane, scrollPane_1);
		GridBagLayout gbl_aircraftPane = new GridBagLayout();
		gbl_aircraftPane.columnWidths = new int[]{0, 246, 0};
		gbl_aircraftPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_aircraftPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_aircraftPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		aircraftPane.setLayout(gbl_aircraftPane);
		
		lblNewLabel = new JLabel("Add Aircraft");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		aircraftPane.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Aircraft ID");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		aircraftPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		aircraftPane.add(textField, gbc_textField);
		textField.setColumns(5);
		
		lblNewLabel_2 = new JLabel("Aircraft Size");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		aircraftPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		String [] aircraftSize = {"Small", "Medium", "Large"};
		comboBox = new JComboBox<Object>(aircraftSize);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		aircraftPane.add(comboBox, gbc_comboBox);
		
		btnNewButton_1 = new JButton("Add Aircraft");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				aircraftPane.remove(lblNewLabel_3);
				aircraftPane.revalidate();
				aircraftPane.repaint();
				ArrayList<Aircraft> aircraftList = Airline.getAirline().getListOfAircrafts();
				String size = (String)comboBox.getSelectedItem();
				for (int i = 0; i < aircraftList.size(); i++) {
					if (aircraftList.get(i).getID() == Integer.valueOf(textField.getText())) {
						aircraftPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
						aircraftPane.revalidate();
						return;
					}
				}
				
				Airline.getAirline().addAircraft(size, Integer.valueOf(textField.getText()));
				aircraftModel.addRow((new Object[]{Integer.valueOf(textField.getText()), size, "Remove"}));
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 5;
		aircraftPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		lblNewLabel_18 = new JLabel("Remove Aircraft");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_18.gridx = 1;
		gbc_lblNewLabel_18.gridy = 6;
		aircraftPane.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		lblNewLabel_17 = new JLabel("Aircraft ID");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_17.gridx = 1;
		gbc_lblNewLabel_17.gridy = 7;
		aircraftPane.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		removeAircraft = new JTextField();
		GridBagConstraints gbc_removeAircraft = new GridBagConstraints();
		gbc_removeAircraft.insets = new Insets(0, 0, 5, 0);
		gbc_removeAircraft.fill = GridBagConstraints.HORIZONTAL;
		gbc_removeAircraft.gridx = 1;
		gbc_removeAircraft.gridy = 8;
		aircraftPane.add(removeAircraft, gbc_removeAircraft);
		removeAircraft.setColumns(10);
		
		removeAircraftbtn = new JButton("Remove");
		GridBagConstraints gbc_removeAircraftbtn = new GridBagConstraints();
		gbc_removeAircraftbtn.gridx = 1;
		gbc_removeAircraftbtn.gridy = 9;
		aircraftPane.add(removeAircraftbtn, gbc_removeAircraftbtn);
		
		lblNewLabel_3 = new JLabel("Invalid ID");
		gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		tabbedPane.addTab("Aircrafts", null, splitPane_1, null);
		
	//User Code
		ArrayList<User> userList = Airline.getAirline().getListOfUsers();
		String[] userHeaders = {"Username", "Password", "Email", "User Type"};
		String[][] userArray = new String[userList.size()][5];
		for (int i = 0; i < aircraftList.size(); i++) {
			userArray[i][0] = userList.get(i).getUsername();
			userArray[i][1] = userList.get(i).getPassword();
			userArray[i][2] = userList.get(i).getEmail();
			userArray[i][3] = userList.get(i).getPriviledge();
		}
		userModel = new DefaultTableModel(userArray, userHeaders);
		table_2 = new JTable(userModel);

		userAdd = new JPanel();
		userModify = new JPanel();
		userPane = new JTabbedPane();
		userPane.addTab("Add User", null, userAdd, null);
		userPane.addTab("Modify User", null, userModify, null);		GridBagLayout gbl_userAdd = new GridBagLayout();
		gbl_userAdd.columnWidths = new int[]{0, 0};
		gbl_userAdd.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_userAdd.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_userAdd.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		userAdd.setLayout(gbl_userAdd);
		
		lblNewLabel_10 = new JLabel("Username");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		userAdd.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		addUsername = new JTextField();
		GridBagConstraints gbc_addUsername = new GridBagConstraints();
		gbc_addUsername.insets = new Insets(0, 0, 5, 0);
		gbc_addUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_addUsername.gridx = 0;
		gbc_addUsername.gridy = 1;
		userAdd.add(addUsername, gbc_addUsername);
		addUsername.setColumns(10);
		
		lblNewLabel_11 = new JLabel("Password");
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 2;
		userAdd.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		addPassword = new JTextField();
		GridBagConstraints gbc_addPassword = new GridBagConstraints();
		gbc_addPassword.insets = new Insets(0, 0, 5, 0);
		gbc_addPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_addPassword.gridx = 0;
		gbc_addPassword.gridy = 3;
		userAdd.add(addPassword, gbc_addPassword);
		addPassword.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Email");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 4;
		userAdd.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		addEmail = new JTextField();
		GridBagConstraints gbc_addEmail = new GridBagConstraints();
		gbc_addEmail.insets = new Insets(0, 0, 5, 0);
		gbc_addEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_addEmail.gridx = 0;
		gbc_addEmail.gridy = 5;
		userAdd.add(addEmail, gbc_addEmail);
		addEmail.setColumns(10);
		
		lblNewLabel_13 = new JLabel("UserType");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 6;
		userAdd.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		addUserType = new JComboBox();
		GridBagConstraints gbc_addUserType = new GridBagConstraints();
		gbc_addUserType.insets = new Insets(0, 0, 5, 0);
		gbc_addUserType.fill = GridBagConstraints.HORIZONTAL;
		gbc_addUserType.gridx = 0;
		gbc_addUserType.gridy = 7;
		userAdd.add(addUserType, gbc_addUserType);
		
		addUserbtn = new JButton("Add User");
		addUserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_addUserbtn = new GridBagConstraints();
		gbc_addUserbtn.gridx = 0;
		gbc_addUserbtn.gridy = 8;
		userAdd.add(addUserbtn, gbc_addUserbtn);
		
		GridBagLayout gbl_userModify = new GridBagLayout();
		gbl_userModify.columnWidths = new int[]{0, 0};
		gbl_userModify.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_userModify.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_userModify.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		userModify.setLayout(gbl_userModify);
		
		lblNewLabel_6 = new JLabel("Change Password");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		userModify.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		changePassword = new JTextField();
		GridBagConstraints gbc_changePassword = new GridBagConstraints();
		gbc_changePassword.insets = new Insets(0, 0, 5, 0);
		gbc_changePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_changePassword.gridx = 0;
		gbc_changePassword.gridy = 1;
		userModify.add(changePassword, gbc_changePassword);
		changePassword.setColumns(10);
		
		savePasswordbtn = new JButton("Save Password");
		savePasswordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_savePasswordbtn = new GridBagConstraints();
		gbc_savePasswordbtn.insets = new Insets(0, 0, 5, 0);
		gbc_savePasswordbtn.gridx = 0;
		gbc_savePasswordbtn.gridy = 2;
		userModify.add(savePasswordbtn, gbc_savePasswordbtn);
		
		lblNewLabel_7 = new JLabel("Change Email");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 3;
		userModify.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		changeEmail = new JTextField();
		GridBagConstraints gbc_changeEmail = new GridBagConstraints();
		gbc_changeEmail.insets = new Insets(0, 0, 5, 0);
		gbc_changeEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeEmail.gridx = 0;
		gbc_changeEmail.gridy = 4;
		userModify.add(changeEmail, gbc_changeEmail);
		changeEmail.setColumns(10);
		
		saveEmailbtn = new JButton("Save Email");
		GridBagConstraints gbc_saveEmailbtn = new GridBagConstraints();
		gbc_saveEmailbtn.insets = new Insets(0, 0, 5, 0);
		gbc_saveEmailbtn.gridx = 0;
		gbc_saveEmailbtn.gridy = 5;
		userModify.add(saveEmailbtn, gbc_saveEmailbtn);
		
		lblNewLabel_8 = new JLabel("Select UserType");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 6;
		userModify.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		changeUserType = new JComboBox();
		GridBagConstraints gbc_changeUserType = new GridBagConstraints();
		gbc_changeUserType.insets = new Insets(0, 0, 5, 0);
		gbc_changeUserType.fill = GridBagConstraints.HORIZONTAL;
		gbc_changeUserType.gridx = 0;
		gbc_changeUserType.gridy = 7;
		userModify.add(changeUserType, gbc_changeUserType);
		
		saveUserTypebtn = new JButton("Save UserType");
		GridBagConstraints gbc_saveUserTypebtn = new GridBagConstraints();
		gbc_saveUserTypebtn.gridx = 0;
		gbc_saveUserTypebtn.gridy = 8;
		userModify.add(saveUserTypebtn, gbc_saveUserTypebtn);
		saveUserTypebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				
			}
		});
		
		
		scrollPane_2 = new JScrollPane(table_2);
		
		
		splitPane = new JSplitPane(1, flightPane, scrollPane);
		tabbedPane.addTab("Flights", null, splitPane, null);
		
		
		
		splitPane_2 = new JSplitPane(1, userPane, scrollPane_2);
		tabbedPane.addTab("Users", null, splitPane_2, null);
		
		
		btnNewButton = new JButton("Log Off");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Login(main, al));
				main.revalidate();
			}
		});
		add(btnNewButton, BorderLayout.SOUTH);
	}

	
	
	
}
