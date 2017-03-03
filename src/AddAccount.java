import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class AddAccount extends JPanel{
	
	private JLabel username , password , name , initialPayment;
	private JLabel lb;
	private JLabel eye ;
	private JTextField usrnametxt  , nametxt ;
	private JPasswordField passwdtxt;
	private JComboBox check;
	private JButton ok ;
	private GridBagConstraints gbc;
	private ImageIcon icon;
	
	public AddAccount()
	{
		setLayout(new GridBagLayout());
		gbc  = new GridBagConstraints();		
		
		setName();
		setPosition();
		setPassword();
		addListenerr();
		setCursor();				
	}
	
	void setName()
	{
		lb = new JLabel("");
		icon = new ImageIcon(getClass().getResource("visible.png"));
		username = new JLabel("Username : ");		
		usrnametxt = new JTextField(14);
		password = new JLabel("Password : ");
		passwdtxt = new JPasswordField(14);
		eye = new JLabel(icon);
		name = new JLabel("Name : ");
		nametxt = new JTextField(14);
		initialPayment = new JLabel("Wallet Balance : ");
		ok = new JButton("OK");
	}
	
	void setPosition()
	{
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		lb.setLayout(new GridBagLayout());
		lb.setBounds(0, 0,600, 500);
		lb.setBorder(new LineBorder(Color.BLUE));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,50,10,0);
		//gbc.ipady=25;
		username.setFont(new Font(username.getName(),Font.BOLD,16));
		gbc.ipady=5;
		lb.add(username,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		usrnametxt.setFont(new Font(username.getName(),Font.PLAIN,15));
		gbc.ipady=5;
		lb.add(usrnametxt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		password.setFont(new Font("Arial",Font.BOLD,16));
		gbc.ipady=5;
		lb.add(password,gbc);
		
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		passwdtxt.setFont(new Font("Arial",Font.BOLD,16));
		gbc.ipady=5;
		//passwdtxt.setText("45");
		lb.add(passwdtxt,gbc);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.insets = new Insets(-10,0,0,0);
		lb.add(eye,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0,50, 0, 0);
		name.setFont(new Font("Arial",Font.BOLD,16));
		gbc.ipady=5;
		lb.add(name,gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		nametxt.setFont(new Font(username.getName(),Font.PLAIN,15));
		gbc.ipady=5;
		lb.add(nametxt,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.insets = new Insets(10,50, 0, 0);
		initialPayment.setFont(new Font("Arial",Font.BOLD,16));
		gbc.ipady=5;
		lb.add(initialPayment,gbc);
		
		String list[] = { "0 Rs." , "250 Rs." , "500 Rs."};
		check = new JComboBox<>(list); 
		gbc.gridx = 1;
		gbc.gridy = 3;
		lb.add(check,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.insets = new Insets(50,220, 0, 0);
		gbc.ipadx=40;
		lb.add(ok,gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0,0, 0, 0);
		gbc.ipady=400;
		gbc.ipadx=700;
		add(lb,gbc);
		
		

	}
	
	void addListenerr()
	{
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(),"  Account Created Successfully.");
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	void setPassword()
	{
		eye.setIcon(icon);		
		Password.showpasswrd(eye, passwdtxt);
	}
	
	

	void setCursor()
	{
		eye.setCursor(Password.curr);
		check.setCursor(Password.curr);
		ok.setCursor(Password.curr);
	}

}