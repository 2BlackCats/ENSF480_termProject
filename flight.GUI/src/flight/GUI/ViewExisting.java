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
		setLayout(new BorderLayout(0, 0));
		
		JButton returnButton = new JButton("Return");
		add(returnButton, BorderLayout.SOUTH);
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				main.setContentPane(new Login(main, al));
				main.revalidate();
			}
		});
		
		table = new JTable();
		add(table, BorderLayout.CENTER);
		
	}

}
