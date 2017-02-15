package yahtzee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class paneel extends JPanel {
	
	private Font font = new Font("Serif", Font.BOLD, 60);
	private dobbelPaneel dp;
	private JButton rollKnop;
	
	public paneel(){
		
		setLayout(new GridLayout(2, 1));
		
		dp = new dobbelPaneel();
		rollKnop = new JButton("Roll");
		
		rollKnop.setFont(font);
		rollKnop.setBackground(Color.RED);
		rollKnop.setForeground(Color.WHITE);
		
		rollKnop.addActionListener(new RollKnopHandler());
		
		add(dp);
		add(rollKnop);
	}
	
	public class RollKnopHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			
			dp.roll();
			
		}
		
	}
	
}
