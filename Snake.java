package snake;

import javax.swing.JFrame;
import java.awt.Color;
public class Snake {
	public static void main(String []args)
	{
		JFrame obj = new JFrame();
		GamePlay gameplay=new GamePlay();
		obj.setBounds(10,10,907,700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
 
}
