import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;

public class Account extends JFrame{
	private JTabbedPane tab;
	private JMenuBar menubar;
	private JMenu menu,help;
	private JMenuItem logout,changepassoword,about,helpcontents,Feedback;
	private static String UserName;
	private static int balance;
	 static AccountDatabase a=new AccountDatabase(UserName);
	final  StudentDetails s=new StudentDetails(this);
	Book b;
	final balance bal=new balance();
	private Account ac;
	public Account(final String UserName) {

		ac=this;
		this.UserName=UserName;
		a=new AccountDatabase(UserName);
		
		setLayout(new GridBagLayout());
		GridBagConstraints c =new GridBagConstraints();
		
		menubar=new JMenuBar();
		
		
		menu=new JMenu("Account ");
		menubar.add(Box.createGlue());
		menubar.add(menu);		
		logout=new JMenuItem("Logout");
		changepassoword=new JMenuItem("Update Password");
		menu.add(changepassoword);
		menu.add(logout);
		
		help=new JMenu("Help");
		about=new JMenuItem("About");
		helpcontents=new JMenuItem("Help Contents");
		
		help.add(about);
		help.add(helpcontents);
		
		menubar.add(help);
		;
		b=new Book(a.getBalance(),this);
		
		add(menubar);
		setJMenuBar(menubar);
		
		tab=new JTabbedPane(JTabbedPane.TOP);
		tab.add("Personal Details",s);
		tab.add("Book",b);
		tab.add("Balance",bal);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipady=330;
		c.insets=new Insets(20, 0, 0, 0);
		add(tab,c);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				updateAccount();
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
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				
				
				
			}
		});
		

		changepassoword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Login.getAccount().setEnabled(false);
				Upadate_Password u=new Upadate_Password(ac);
				u.setSize(new Dimension(400,300));
		        u.setVisible(true);
				u.setDefaultCloseOperation(HIDE_ON_CLOSE);
				
			}
		});
		
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void updateAccount(){
		a.userInitialise(s);
		a.userBal(bal);
	}
	
	
	public void updateAccount(String str){
		a.updateAccount(str.split(" "));
	}
	
	public void updateTripData(String str, int balance){
		a.updateTrip(str.split(" "),balance,bal);
	}

	public void updatePassword(int CurrPassword,int NewPassword){
		a.updatePass(CurrPassword,NewPassword);
	}
	
}