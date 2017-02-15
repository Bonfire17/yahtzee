package yahtzee;

import java.awt.*;
import javax.swing.*;

public class dobbelPaneel extends JPanel{
	
	private dobbelSteen[] steen = new dobbelSteen[5];
	
	public dobbelPaneel(){
		setLayout(new GridLayout(1,5));
		for(int i = 0; i < 5; i++){
			steen[i] = new dobbelSteen();
		}
		for(int i = 0; i < 5; i++){
			add(steen[i]);
		}
	}

	public void roll() {
		for(int i = 0; i < 5; i++){
			steen[i].roll();
		}
	}
}
