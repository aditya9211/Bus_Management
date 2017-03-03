import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Upadate_Password extends JFrame {
	JLabel currpass,newpass,retypepass;
	JButton confirm,cancel;
	JPasswordField Currpass,Newpass,Retypepass;
	private String UserName;
	private Account a;
	public Upadate_Password(Account a)	{
		
			this.a=a;
			this.UserName=UserName;
			this.setLayout(new GridBagLayout());
			GridBagConstraints c=new GridBagConstraints();
			
			Font font=new Font("Arial",Font.BOLD,14);
			currpass=new JLabel("Current Password : ");
			newpass=new JLabel("New Password : ");
			retypepass=new JLabel("Re-Type Password : ");
			
			currpass.setFont(font);
			newpass.setFont(font);
			retypepass.setFont(font);
			
			Currpass=new JPasswordField(20);
			Newpass=new JPasswordField(20);
			Retypepass=new JPasswordField(20);
			
			Currpass.setFont(new Font("Arial",Font.BOLD,16));
			Currpass.setBackground(new Color(224,224,224));
			
			Newpass.setFont(new Font("Arial",Font.BOLD,16));
			Newpass.setBackground(new Color(224,224,224));
			
			Retypepass.setFont(new Font("Arial",Font.BOLD,16));
			Retypepass.setBackground(new Color(224,224,224));
			
			
			
			confirm=new JButton("Confirm");
			cancel=new JButton("Cancel");
			
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.insets=new Insets(-200,-40,0,0);
			add(currpass,c);
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=1;
			c.insets=new Insets(-110,-40, 0, 0);
			add(newpass,c);
		
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=2;
			c.insets=new Insets(-30, -40, 0, 0);
			add(retypepass,c);
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=0;
			c.ipady=5;
			c.insets=new Insets(-200, -0, 0, 0);
			add(Currpass,c);
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=1;
			c.insets=new Insets(-110, 0, 0, 0);
			add(Newpass,c);
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=2;
			c.insets=new Insets(-30, 0, 0, 0);
			add(Retypepass,c);
			
			c.ipady=10;
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=3;
			c.ipadx=3;
			c.insets=new Insets(40, -70, 0, 0);
			add(confirm,c);
			
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=3;
			c.ipadx=0;
			c.insets=new Insets(38, 40, 0, 0);
			add(cancel,c);
			
			
			this.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent arg0) {
					Login.getAccount().setEnabled(false);
					
				}
				
				@Override
				public void windowIconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent arg0) {
					// TODO Auto-generated method stub
					Login.getAccount().setEnabled(true);
					dispose();
				}
				
				@Override
				public void windowClosed(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowActivated(WindowEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
				
			
			event e=new event();
			confirm.addActionListener(e);
		}		
	public class event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String str1=String.valueOf(Newpass.getPassword());
			String str2=String.valueOf(Retypepass.getPassword());
			String str3=String.valueOf(Currpass.getPassword());
			if(str1.equals(str2)){
				
				a.updatePassword(str3.hashCode(),str2.hashCode());
				JOptionPane.showMessageDialog(new JFrame(),"    Password Changed  ");
				
			}
			
			else
				JOptionPane.showMessageDialog(new JFrame(),"    Invalid password  ");
			
		}
		
		
	}
	
	

	
	}