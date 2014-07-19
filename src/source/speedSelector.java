package source;

import java.awt.BorderLayout;
<<<<<<< HEAD
=======
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
>>>>>>> origin/master

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
<<<<<<< HEAD
public class speedSelector extends JPanel{
=======
public class speedSelector extends JPanel implements KeyListener{
>>>>>>> origin/master

	private static final String[] speeds = {"50", "100", "150", "200", "250", "300", "350", "400", "450", "500", "550", "600", "650", "700", "750", "800", "850", "900", "950", "1000"};
	
	@SuppressWarnings("unused")
	private JLabel label;
	private JComboBox<String> comboBox;
	
	public speedSelector() {
		
		super(new BorderLayout());
		this.add(label = new JLabel("Read Speed"), BorderLayout.NORTH);
		this.add(comboBox = new JComboBox<>(speeds), BorderLayout.SOUTH);
<<<<<<< HEAD
=======
		this.addKeyListener(this);
>>>>>>> origin/master
	}
	
	public int getSpeed() {
		
		int selectedSpeed = Integer.parseInt(speeds[comboBox.getSelectedIndex()]);
		return selectedSpeed;
	}
<<<<<<< HEAD
	
	public void setFocusable (boolean bool) {
		
		comboBox.setFocusable(bool);
=======

	public void keyPressed(KeyEvent arg0) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
>>>>>>> origin/master
	}
}
