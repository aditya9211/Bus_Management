import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Payment extends JFrame implements ActionListener  {
	JLabel fare,curr_credit;
	JTextField credit;
	JPanel history,panel1;
	Font font;
	JButton confirm ,cancel;
	Account a;
	int balance;
	private String str;
	public Payment(String title,int balance,Account a,String str)
	{
		this.str=str;
		this.balance=balance;
		this.a=a;
		setTitle(title);
		setLayout(new BorderLayout());
		setValue();
		
		addValue();
		setOutlet();
		cancel.addActionListener(this);
		confirm.addActionListener(this);
	}
	
	public void setValue(){
		fare=new JLabel("The trip Cost is 25 Rupees",SwingConstants.CENTER);
		font=new Font("Aerial",Font.BOLD,14);
		curr_credit=new JLabel("You current balance : ");
		confirm=new JButton("Confirm");
		cancel=new JButton("Cancel");
		credit=new JTextField("500");
		credit.setEditable(false);
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(2,2,20,20));
		fare.setFont(font);
	}
	
	public void addValue(){
		add(fare,BorderLayout.NORTH);
		panel1.add(curr_credit);
		panel1.add(credit);
		panel1.add(confirm);
		panel1.add(cancel);
		add(panel1,BorderLayout.CENTER);
	}
	
	public void setOutlet(){
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		String str1=arg0.getActionCommand();
		if(str1.equals("Cancel"))
			dispose();
		else if(str1.equals("Confirm"))
		{
			dispose();
			JOptionPane.showMessageDialog(new JFrame("Ticket book"), "Your ticket has been confirmed \n please be on time before 15 minutes");
			a.updateAccount();
			
			a.updateTripData(str,balance-25);
		}
}
}
