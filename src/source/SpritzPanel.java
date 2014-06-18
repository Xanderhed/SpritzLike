package source;

import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;

@SuppressWarnings("serial")
public class SpritzPanel extends JPanel implements ActionListener {

	private JButton openFileButton;
	private speedSelector speedSelect;
	private JFileChooser fileSelect;
	
	//constructor
	public SpritzPanel() {
		
		this.add(openFileButton = new JButton("Open File"));
		this.add(speedSelect = new speedSelector());
		fileSelect = new JFileChooser();
		openFileButton.addActionListener(this);
	}
	
	//interface methods
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == openFileButton) {
			
			int returnValue = fileSelect.showOpenDialog(SpritzPanel.this);
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				
				File file = fileSelect.getSelectedFile();
				//TODO pass the file to a worker thread somehow
			}
		}
	}
}
