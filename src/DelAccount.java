import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class DelAccount extends JPanel{
	
	private JLabel username;
	private JTextField usrnametxt;
	private JButton ok ;
	private JLabel lb;
	public DelAccount()
	{
		setLayout(null);		
		setName();
		setPosition();
		addComponent();
		addListener();
		setCursor();
	
	}
	
	void setName()
	{
		lb = new JLabel("");
		username = new JLabel("Username : ");
		usrnametxt = new JTextField(14);
		ok = new JButton("OK");
	}
	
	void setPosition()
	{
		lb.setLayout(null);
		lb.setBounds(70, 70,690, 400);
		lb.setBorder(new LineBorder(Color.BLUE));
		
		username.setFont(new Font("Arial",Font.BOLD,16));
		username.setBounds(120,150,200,30);
		
		usrnametxt.setFont(new Font("Arial",Font.PLAIN,15));
		usrnametxt.setBounds(360,150,200,30);
		
		ok.setFont(new Font("Arial",Font.BOLD,15));
		ok.setBounds(300,280,70,30);
		
	}
	
	void addListener()
	{
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),"  Account Deleted Successfully.");
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	void addComponent()
	{
		add(lb);
		lb.add(username);
		lb.add(usrnametxt);
		lb.add(ok);
		add(lb);
	}
	
	void setCursor()
	{
		ok.setCursor(Password.curr);
		
	}
}