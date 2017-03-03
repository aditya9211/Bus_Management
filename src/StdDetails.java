import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.event.*;

public class StdDetails extends JFrame implements ItemListener{
	
	private JPanel panel1;
	private JButton logout;
	private JRadioButton showdata,updatedata ;
	private ButtonGroup bg;
	private DataRetrieval dataret;
	private UpdateDetails update;
	private Admin d;
	public StdDetails()
	{
			setLayout(null);
			panel1 = new JPanel();
			update = new UpdateDetails();
			dataret = new DataRetrieval();
			panel1.setLayout(null);
			
			bg= new ButtonGroup();
			
			setName();
			setPosition();
			addListener();
			addComponent();
			setCursor();
			setVisible(true);
			setSize(700,760);
		//setLocation(150, 95);
	}
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
			Object item= e.getItem();
			
			if(item.equals(showdata))
			{
				update.setVisible(false);
				dataret.setVisible(true);
			}
			else
			{
				//UpdateDetails update = new UpdateDetails();
				//update.setBounds(0,50,700,900);
				dataret.setVisible(false);
				update.setVisible(true);
				//this.getContentPane().remove(dataret);
				//add(update);
			}
	}
		
	
	void setName()
	{
		logout = new JButton("Logout");
		showdata = new JRadioButton("Show Details",true);
		updatedata = new JRadioButton("Update Details");	
	}
	
	void setPosition()
	{
		this.setLocation(300,0);
		logout.setBounds(550,15,100,20);
		showdata.setBounds(120,5,120,40);
		updatedata.setBounds(300,5,150,40);
		
		showdata.setFont(new Font("Arial",Font.BOLD,13));
		updatedata.setFont(new Font("Arial",Font.BOLD,13));
		panel1.setBounds(0,0,700,50);
		
		update.setBounds(0,50,700,900);
		dataret.setBounds(0,50,700,900);
		update.setVisible(false);
		dataret.setVisible(true);
	}
	
	void addListener()
	{
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(new JFrame(),"  Logout Successfully.");
				d = Login.getAdmin();
			//	d.setVisible(true);
				d.setEnabled(true);
				setVisible(false);
				// TODO Auto-generated method stub
				
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
					d = Login.getAdmin();
				//	d.setVisible(true);
					d.setEnabled(true);
					setVisible(false);
				// TODO Auto-generated method stub
				
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
	
	void addComponent()
	{
		add(logout);
		
		bg.add(showdata);
		bg.add(updatedata);	
		
		panel1.add(showdata);
		panel1.add(updatedata);
	
		add(panel1);
			
		showdata.addItemListener(this);
		updatedata.addItemListener(this);
		
		add(update);
		add(dataret);
		
	}
	
	void setCursor()
	{
		logout.setCursor(Password.curr);
		showdata.setCursor(Password.curr);
		updatedata.setCursor(Password.curr);
	}
	
	/*public static void main(String args[]){
		StdDetails s=new StdDetails();
		s.setVisible(true);
		s.pack();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE	);
		
	}
	*/
}

