package source;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class speedSelector extends JPanel {

	private JLabel label;
	private JComboBox speed;
	
	public speedSelector() {
		
		super(new BorderLayout());
		String[] speeds = {"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000"};
		this.add(label = new JLabel("Read Speed"), BorderLayout.NORTH);
		this.add(speed = new JComboBox(speeds), BorderLayout.SOUTH);
	}
}
