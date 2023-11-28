package flight.GUI;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import dataBase.*;
import entity.Airline;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static private Airline al;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReadDB db = new ReadDB();
					al = db.filledAirline();
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new Login(this, al);
		setResizable(false);
		setContentPane(contentPane);
		setTitle("Flight Reservation Application");
		addWindowListener(new WindowAdapter(){
			public void WindowClosing(WindowEvent e) {
				
				new UpdateDB();
				
			}
		});
		revalidate();
	}
}
