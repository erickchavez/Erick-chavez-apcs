package flag;
import javax.swing.*;

public class Main {
	
	public static void main(String [] args){
		Flag flag = new Flag();
		JFrame frame = new JFrame("Flag");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(flag);
		
		frame.pack();
		frame.setVisible(true);
	}
}