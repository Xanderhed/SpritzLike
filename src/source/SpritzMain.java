package source;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class SpritzMain extends Container implements Runnable{
	
	public static final String NAME = "Alex's Spritz Clone";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	
	public SpritzPanel panel;
	public JLabel text;
	
	private boolean running;
	private int wordIndex;
	private JFrame frame;
	
	public SpritzMain () {
		
		frame = new JFrame(NAME);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setMinimumSize(new Dimension(WIDTH / 2, HEIGHT / 2));
		this.setMaximumSize(new Dimension(WIDTH * 2, HEIGHT * 2));
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void start() {
		
		running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		
		running = false;
	}
	
	public void init() {
		
		this.setLayout(new BorderLayout());
		this.add(panel = new SpritzPanel(), BorderLayout.NORTH);
		this.add(text = new JLabel("Text appears here."), BorderLayout.CENTER);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(text.getFont().deriveFont(48f));
		this.revalidate();
		this.setVisible(true);
	}
	
	public void run() {
		
		init();
		long lastTime = System.currentTimeMillis();
		long delta = 0;
		
		while(running) {
			if(!panel.fileLoaded) {
				System.out.println("No file has been selected");
				continue;
			}
			int speed = panel.getSpeed();
			long currentTime = System.currentTimeMillis();
			Double timeBetweenTicks = 60000.0 / (double)speed;
			delta += currentTime - lastTime;
			lastTime = currentTime;
			if(delta >= timeBetweenTicks) {
				delta = 0;
				tickAndRender();
			}
		}
	}
	
	private void tickAndRender() {
		System.out.println("The system has ticked");
		try {
			text.setText(panel.words.get(panel.getIndex()));
			if(!panel.paused) {
				panel.nextWord();
			}
			text.revalidate();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			panel.paused = true;
			panel.lastWord();
		}
	}
	
	public static void main(String[] args) {
		
		new SpritzMain().start();
	}

}
