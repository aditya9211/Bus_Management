import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class DataRetrieval extends JPanel{
	
	private JLabel personaldetails , bookingdetails ;
	private JComboBox dd,mm,yyyy,deptname,stream;
	private JRadioButton male ,female;
	private JLabel rollno,name,dob,gender,emailid,mobno,dept,year;
	private JLabel balance,ridehistory;
	private JTextField baltxt;
	private JTable rides;
	private JTextField rollnotxt,nametxt,emailtxt,mobnotxt;
	private ButtonGroup bg;
	private JScrollPane scpane;
	private JLabel lb,lb1;
	
	private String date[] = {"1","2","3","4","5","6","7","8","9","10",
			"11","12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31"};
	
	private String month[] = {"1","2","3","4","5","6","7","8","9","10",
			"11","12"};
	
	private String years[] = {"1991","1992","1993","1994","1995","1996",
			"1997","1998","1999","2000","2001"};
	
	private String branch[] = { "CSE" , "CCE" , "ECE" , "MME" , "ME" , "MTech" , "Phd" };
	
	private String clgyear[] = { "I" , "II" , "III", "IV"};
	
	private Object data[][]={};
	
	public DataRetrieval()
	{
		setLayout(null);
		
		rides = new JTable(100,4);
		dd = new JComboBox(date);
		mm = new JComboBox(month);
		yyyy = new JComboBox(years);
		bg = new ButtonGroup();
		stream = new JComboBox(branch);
		deptname = new JComboBox(clgyear);
		
		setName();
		setPosition();
		addComponent();
		setcursor();
		//dd.setSelectedItem("dd");
		
		
	
		JScrollPane pan = new JScrollPane(this);
		pan.setPreferredSize(new Dimension(200,1000));
		pan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
	}
	
	void setName()
	{
		
		lb=new JLabel("");
		personaldetails = new JLabel("Personal Details");
		rollno = new JLabel("Roll No : ");
		rollnotxt = new JTextField(14);
		name = new JLabel("Name : ");
		nametxt = new JTextField(14);
		dob = new JLabel("D.O.B : ");
		gender = new JLabel("Gender : ");
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		emailid = new JLabel("Email ID : ");
		emailtxt = new JTextField(14);
		mobno = new JLabel("Mob. No. : ");
		mobnotxt = new JTextField(14);
		dept = new JLabel("Dept : ");
		year = new JLabel("Year : ");
		
		lb1=new JLabel("");
		bookingdetails = new JLabel("Booking Details");
		balance = new JLabel("Wallet Balance : ");
		baltxt = new JTextField(14);
		ridehistory = new JLabel("Rides History : ");
		scpane = new JScrollPane(rides);
		
	}
	
	void setPosition()
	{
		lb.setBounds(30, 0,600, 400);
		lb.setBorder(new LineBorder(Color.BLUE));
		
		personaldetails.setBounds(50, 20, 200, 30);
		personaldetails.setFont(new Font("Arial",Font.BOLD,18));
		
		rollno.setBounds(50, 70, 200, 30);
		rollno.setFont(new Font("Arial",Font.BOLD,15));
		
		rollnotxt.setBounds(250, 70, 200, 30);
		rollnotxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		name.setBounds(50, 110, 200, 30);
		name.setFont(new Font("Arial",Font.BOLD,15));
		
		nametxt.setBounds(250, 110, 200, 30);
		nametxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		dob.setBounds(50, 150, 200, 30);
		dob.setFont(new Font("Arial",Font.BOLD,15));
		
		dd.setFont(new Font("Arial",Font.PLAIN,15));
		dd.setBounds(250, 150, 50, 30);
		
		mm.setFont(new Font("Arial",Font.PLAIN,15));
		mm.setBounds(310, 150, 50, 30);
		
		yyyy.setFont(new Font("Arial",Font.PLAIN,15));
		yyyy.setBounds(370, 150, 60, 30);
		
		gender.setBounds(50, 190, 200, 30);
		gender.setFont(new Font("Arial",Font.BOLD,15));
		
		male.setBounds(250, 190, 100, 30);
		male.setFont(new Font("Arial",Font.PLAIN,15));
		
		female.setBounds(350, 190, 200, 30);
		female.setFont(new Font("Arial",Font.PLAIN,15));
		
		emailid.setBounds(50, 230, 200, 30);
		emailid.setFont(new Font("Arial",Font.BOLD,15));
		
		emailtxt.setBounds(250, 230, 200, 30);
		emailtxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		mobno.setBounds(50, 270, 200, 30);
		mobno.setFont(new Font("Arial",Font.BOLD,15));
		
		mobnotxt.setBounds(250, 270, 200, 30);
		mobnotxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		dept.setBounds(50, 310, 200, 30);
		dept.setFont(new Font("Arial",Font.BOLD,15));
		
		stream.setBounds(250, 310, 200, 30);
		stream.setFont(new Font("Arial",Font.BOLD,15));
		
		year.setBounds(50, 350, 200, 30);
		year.setFont(new Font("Arial",Font.BOLD,15));
		
		deptname.setBounds(250, 350, 200, 30);
		deptname.setFont(new Font("Arial",Font.BOLD,15));
		
		lb1.setBounds(30, 410,600, 250);
		//lb.setLayout(new GridBagLayout());
		lb1.setBorder(new LineBorder(Color.BLUE));
		
		bookingdetails.setBounds(50, 420, 200, 30);
		bookingdetails.setFont(new Font("Arial",Font.BOLD,18));
		
		balance.setBounds(50, 470, 200, 30);
		balance.setFont(new Font("Arial",Font.BOLD,15));
		
		baltxt.setBounds(250, 470, 200, 30);
		baltxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		ridehistory.setBounds(50, 510, 200, 30);
		ridehistory.setFont(new Font("Arial",Font.BOLD,15));
		
		scpane.setBounds(50, 540, 500, 100);
		
		rides.setFillsViewportHeight(true);
		rides.setPreferredScrollableViewportSize(new Dimension(400,400));
		
	}
	void addComponent()
	{

		lb.add(personaldetails);
		
		
		
		lb.add(rollno);
	
		
		
		
		lb.add(rollnotxt);
		
		
		
		
		lb.add(name);
	
		
		
		lb.add(nametxt);
		
		
		
		
		lb.add(dob);
		
		lb.add(dd);
		lb.add(mm);
		lb.add(yyyy);
		lb.add(gender);
		lb.add(male);
		bg.add(male);
		bg.add(female);
		lb.add(female);
		lb.add(emailid);
	
		
		
		lb.add(emailtxt);
		
		
		
		lb.add(mobno);
	
		
		
		lb.add(mobnotxt);
		
		
		
		lb.add(dept);
		
		lb.add(stream);
		add(lb);
		
		
		
		lb.add(year);
		lb.add(deptname);
		
		add(lb1);
		
		
		
		add(bookingdetails);
		
		
		
		add(balance);
	
		
		
		add(baltxt);
		add(ridehistory);
		
		add(scpane);

		
	}
	
	void setcursor()
	{

		dd.setCursor(Password.curr);
		
		mm.setCursor(Password.curr);
		
		yyyy.setCursor(Password.curr);
	
		male.setCursor(Password.curr);

		female.setCursor(Password.curr);
		
		stream.setCursor(Password.curr);
	
		deptname.setCursor(Password.curr);
		
	}
}