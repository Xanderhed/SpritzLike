package source;

import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class speedSelector extends JPanel{
	private static final String[] speeds = {"50", "100", "150", "200", "250", "300", "350", "400", "450", "500", "550", "600", "650", "700", "750", "800", "850", "900", "950", "1000"};

	private JLabel label;
	private JComboBox<String> comboBox;

	public speedSelector() {
		super(new BorderLayout());
		this.add(label = new JLabel("Read Speed"), BorderLayout.NORTH);
		this.add(comboBox = new JComboBox<>(speeds), BorderLayout.SOUTH);
	}

	public int getSpeed() {

		int selectedSpeed = Integer.parseInt(speeds[comboBox.getSelectedIndex()]);
		return selectedSpeed;
	}

	public void setFocusable (boolean bool) {

		comboBox.setFocusable(bool);
	}
}