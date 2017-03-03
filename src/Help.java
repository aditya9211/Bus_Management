import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Help extends JFrame{
	JLabel helpp;
	
	Help()
	{
		helpp = new JLabel("Folllow Instructions Behave as a Human");
		add(helpp);
		setVisible(true);
		setSize(400, 500);
	}
	
}