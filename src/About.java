import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class About extends JFrame{
	JLabel about ;
	
	public About()
	{
		about = new JLabel("Developed by Aditya");
		setSize(400, 500);
		setVisible(true);
		add(about);
		
	}

}