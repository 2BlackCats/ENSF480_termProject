package flight.GUI;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import entity.Airline;
public class ViewExisting extends JPanel {
	private JFrame main;
	private JTable table;
	private String user;

	/**
	 * Create the panel.
	 */
	
	
	public ViewExisting(JFrame main, String user, Airline al) {
		this.main = main;
		this.user = user;
		setLayout(null);
		
		JButton returnButton = new JButton("Return");
		returnButton.setBounds(6, 187, 450, 29);
		add(returnButton);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Login(main, al));
				main.revalidate();
			}
		});
		
		table = new JTable();
		table.setBounds(27, 43, 397, 132);
		add(table);
		
		JButton btnNewButton = new JButton("Sign off");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Figure out the seat and name relation
			}
		});
		btnNewButton.setBounds(327, 6, 117, 29);
		add(btnNewButton);
		
	}

}
