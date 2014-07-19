package source;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class SpritzMain extends Container implements Runnable{
	
	public static final String NAME = "Alex's Spritz Clone";
	public static final int WIDTH = 500;
	public static final int HEIGHT = 300;
	
	public SpritzPanel panel;
	public JLabel text;
	
	private boolean running;
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
		bind();
		this.revalidate();
		this.setVisible(true);
	}
	
	public void bind() {
		
		pauseAction pause = new pauseAction();
		//nextAction next = new nextAction();
		//lastAction last = new lastAction();
		
		panel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "doPause");
		//panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "doNext");
		//panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "doLast");
		
		panel.getActionMap().put("doPause", pause);
		//panel.getActionMap().put("doNext", next);
		//panel.getActionMap().put("doLast", last);
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
	
	private class pauseAction extends AbstractAction {
		
		public void actionPerformed(ActionEvent spacebar) {
			System.out.println("The spacebar has been registered");
			panel.paused = !panel.paused;
		}
	}
	
	private class nextAction extends AbstractAction {
		
		public void actionPerformed(ActionEvent right) {
			
		}
	}
	
	private class lastAction extends AbstractAction {
		
		public void actionPerformed(ActionEvent left) {
			
		}
	}
}
