package source;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Container;


public class SpritzMain{
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				final JFrame frame = new JFrame("Alex's Spritz Clone");
				final Container container = frame.getContentPane();
				frame.setSize(300, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				container.add(new SpritzPanel());
				frame.setVisible(true);
			}
		});
	}

}
