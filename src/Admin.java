import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.event.*;

public class Admin extends JFrame{

	private JTabbedPane tab;
	private JButton logout ;
	private JLabel help , about;
	private ImageIcon icon;
	private ImageIcon icon1;
	private Login log;
	private AddAccount add;
	private DelAccount del ;
	private Student stddetails; 
	private BusDetails busdetails;
	private String UserName;
	public Admin (String UserName)
	{
		this.UserName=UserName;
		setLayout(null);
		
		log = new Login();
		tab = new JTabbedPane();	
		add = new AddAccount();	
		del = new DelAccount();	
		stddetails = new Student();	
		busdetails = new BusDetails();
		
		setName();
		setPosition();
		addListener();
		setCursor();
		addComponent();
		
		setSize(870, 650);
		setLocation(170, 40);
		
		
	}
	
	void setName()
	{
		icon = new ImageIcon(getClass().getResource("help.png"));
		help = new JLabel(icon);
		icon1 = new ImageIcon(getClass().getResource("about.png"));
		about = new JLabel(icon1);
		logout = new JButton("Logout");
		
	}
	
	void setPosition()
	{
		help.setBounds(550, 0, 40, 40);
		about.setBounds(600, 0, 40, 40);
		logout.setBounds(750, 28, 100, 25);
		tab.setBounds(0, 60, 850, 550);
	}
	
	void addListener()
	{
		
		help.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				new Help();
				// TODO Auto-generated method stub
				
			}
		});

	about.addMouseListener(new MouseListener() {
	
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			new About();
			// TODO Auto-generated method stub
			
		}
	});
		
	logout.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(new JFrame(),"  Logout Successfully.");
			// TODO Auto-generated method stub
			log=Login.getLogin();
			log.setVisible(true);
			setVisible(false);
			
		}
	});

	
	this.addWindowListener(new WindowListener() {
		
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			log=Login.getLogin();
			log.setVisible(true);
			setVisible(false);			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	
	}
	
	void setCursor()
	{
		help.setCursor(Password.curr);
		about.setCursor(Password.curr);
		logout.setCursor(Password.curr);
	}
	
	void addComponent()
	{
		add(help);
		add(about);
		add(logout);
		add(tab);
		tab.addTab("Create Account",add);
		tab.addTab("Delete Account",del);
		tab.addTab("Student Details",stddetails);
		tab.addTab("Bus Details",busdetails);
	}
	
}