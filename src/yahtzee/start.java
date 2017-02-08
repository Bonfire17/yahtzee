package yahtzee;

import javax.swing.*;

public class start extends JFrame {
	
	static JFrame x;
	
	public static void main(String[] args){
		x = new JFrame();
		x.setSize(1000, 700);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setResizable(false);
		x.setContentPane(new paneel());
		x.setVisible(true);
	}
}
