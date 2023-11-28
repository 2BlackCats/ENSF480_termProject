package flight.GUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class BookNew extends JPanel {
	private JTable flightTable;
	private JTable seatTable;

	/**
	 * Create the panel.
	 */
	public BookNew() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		tabbedPane.addTab("Book Flight", null, splitPane, null);
		
		flightTable = new JTable();
		splitPane.setLeftComponent(flightTable);
		
		seatTable = new JTable();
		splitPane.setRightComponent(seatTable);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Options", null, panel, null);
		
	}

}
