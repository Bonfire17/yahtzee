package yahtzee;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class dobbelSteen extends JPanel{
	
	private int num = 6;
	private boolean locked = false;
	private Random rand;
	private int teller;
	
	private Timer timer;
	private JButton holdKnop;
	
	public dobbelSteen(){
		setLayout(null);
		setBackground(Color.BLACK);
		rand = new Random();
		
		timer = new Timer(200, new TimerHandler());
		
		holdKnop = new JButton("HOLD");
		holdKnop.setBounds(10, 130, 100, 30);
		holdKnop.setBackground(Color.GREEN);
		holdKnop.addActionListener(new HoldKnopHandler());
		
		add(holdKnop);
	}
	public void roll(){
		holdKnop.setEnabled(false);
		teller = 0;
		timer.start();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(10, 10, 100, 100);
		g.setColor(Color.BLACK);
		switch(num){
		case 1:
			g.fillOval(50, 50, 10, 10);
			break;
		case 2:
			g.fillOval(25, 25, 10, 10);
			g.fillOval(85, 85, 10, 10);
			break;
		case 3:
			g.fillOval(50, 50, 10, 10);
			g.fillOval(25, 25, 10, 10);
			g.fillOval(85, 85, 10, 10);
			break;
		case 4:
			g.fillOval(25, 25, 10, 10);
			g.fillOval(85, 85, 10, 10);
			g.fillOval(25, 85, 10, 10);
			g.fillOval(85, 25, 10, 10);
			break;
		case 5:
			g.fillOval(25, 25, 10, 10);
			g.fillOval(85, 85, 10, 10);
			g.fillOval(25, 85, 10, 10);
			g.fillOval(85, 25, 10, 10);
			g.fillOval(50, 50, 10, 10);
			break;
		case 6:
			g.fillOval(25, 25, 10, 10);
			g.fillOval(85, 85, 10, 10);
			g.fillOval(25, 85, 10, 10);
			g.fillOval(85, 25, 10, 10);
			g.fillOval(50, 85, 10, 10);
			g.fillOval(50, 25, 10, 10);
			break;
		}
	}
	public class HoldKnopHandler implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			
			if(locked){
				holdKnop.setBackground(Color.GREEN);
				locked = false;
			}else{
				holdKnop.setBackground(Color.RED);
				locked = true;
			}
			
		}
		
	}
	public class TimerHandler implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(!locked){
				num = rand.nextInt(6) + 1;
				repaint();
			}
			teller++;
			if(teller >= 10){
				timer.stop();
				teller = 0;
				holdKnop.setEnabled(true);
			}
		}
		
	}
	
}
