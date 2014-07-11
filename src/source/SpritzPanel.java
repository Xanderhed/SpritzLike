package source;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SpritzPanel extends JPanel implements ActionListener, KeyListener {

	private JButton openFileButton;
	private speedSelector speedSelect;
	private JFileChooser fileSelect;
	private File file;
	private int index;
	
	
	public ArrayList<String> words;
	
	public boolean fileLoaded;
	public boolean paused;
	
	//constructor
	public SpritzPanel() {
		
		this.add(openFileButton = new JButton("Open File"));
		this.add(speedSelect = new speedSelector());
		fileLoaded = false;
		paused = false;
		index = 0;
		words = new ArrayList<String>();
		fileSelect = new JFileChooser();
		openFileButton.addActionListener(this);
		//this.addKeyListener(this);
	}
	
	//interface methods
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == openFileButton) {
			
			int returnValue = fileSelect.showOpenDialog(SpritzPanel.this);
			if(returnValue == JFileChooser.APPROVE_OPTION) {
				
				file = fileSelect.getSelectedFile();
				parseFile();
				fileLoaded = true;
			}
		}
	}
	
	public int getSpeed() {
		
		return speedSelect.getSpeed();
	}
	
	private void parseFile() {
		words.clear();
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				words.add(scanner.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void nextWord() {
		index++;
	}
	
	public void lastWord() {
		index--;
	}
	
	public int getIndex() {
		return index;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_P) {
			if(paused) {
				paused = false;
			}else {
				paused = true;
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
