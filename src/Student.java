import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Student extends JPanel{
	private JLabel username;
	private JTextField usrnametxt;
	private JButton ok ;
	private GridBagConstraints gc ;
	
	public Student()
	{
		setLayout(new GridBagLayout());
		gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		setName();
		setPosition();
		addListener();
		setCursor();
			
	}
	
	void setName()
	{
		username = new JLabel("Username : ");
		usrnametxt = new JTextField(14);
		ok = new JButton("OK");
	}
	
	void setPosition()
	{

		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(0,10,50,0);
		//gc.ipady=25;
		username.setFont(new Font(username.getName(),Font.BOLD,16));
		gc.ipady=5;
		add(username,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(0,50,50,0);
		usrnametxt.setFont(new Font(username.getName(),Font.PLAIN,15));
		gc.ipady=5;
		add(usrnametxt,gc);
		
		gc.gridx = 2;
		gc.gridy = 0;
		gc.insets = new Insets(0,0,50,0);
		gc.ipadx=0;
		add(ok,gc);
	}
	
	void addListener()
	{
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(new JFrame()," Invalid Details ");
				Admin d = Login.getAdmin();
				d.setEnabled(false);
				new StdDetails();
				
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	void setCursor()
	{
		ok.setCursor(Password.curr);
	}
}