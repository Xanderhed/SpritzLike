package source;

import java.io.*;
import java.util.Scanner;
import javax.swing.SwingWorker;

public class spritzWorker extends SwingWorker<String, String>{

	private Scanner scanner;
	
	public spritzWorker(File file) {
		
		try {
			scanner = new Scanner(file);
		}
		catch (FileNotFoundException ignore){}
	}
	
	public String doInBackground() {
		
		String nextWord = "";
		nextWord = scanner.next();
		return nextWord;
	}
}
