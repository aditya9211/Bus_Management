import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class UpdateDetails extends JPanel{

	private JLabel personaldetails, paymentdetails ;
	private JComboBox dd,mm,yyyy,deptname,stream,add;
	private JRadioButton male ,female;
	private JLabel rollno,eye,name,password,dob,gender,emailid,mobno,dept,year;
	private JLabel balance,bal,lb,lb1;
	private JTextField baltxt;
	private JPasswordField passwordtxt;
	private JTextField rollnotxt,nametxt,emailtxt,mobnotxt;
	private ButtonGroup bg;
	private JButton update;
	private ImageIcon icon;
	
	private String date[] = {"1","2","3","4","5","6","7","8","9","10",
			"11","12","13","14","15","16","17","18","19","20",
			"21","22","23","24","25","26","27","28","29","30","31"};
	
	private String month[] = {"1","2","3","4","5","6","7","8","9","10",
			"11","12"};
	
	private String years[] = {"1991","1992","1993","1994","1995","1996",
			"1997","1998","1999","2000","2001"};
	
	private String branch[] = { "CSE" , "CCE" , "ECE" , "MME" , "ME" , "MTech" , "Phd" };
		
	private String clgyear[] = { "I" , "II" , "III", "IV"};
	
	private String list[] = { "0 Rs." , "250 Rs." , "500 Rs."};
	
	public UpdateDetails()
	{
		setLayout(null);
		
		setName();
		icon = new ImageIcon(getClass().getResource("visible.png"));
		bg = new ButtonGroup();
		dd = new JComboBox<>(date);
		eye = new JLabel(icon);
		mm = new JComboBox<>(month);
		yyyy = new JComboBox<>(years);
		stream = new JComboBox<>(branch);
		deptname = new JComboBox<>(clgyear);
		add = new JComboBox<>(list); 
		
		setLocation();
		addComponent();
		setCursor();
		addListener();
		setPassword();
			

		
		/*JScrollPane pan = new JScrollPane(this);
		pan.setPreferredSize(new Dimension(200,1000));
		pan.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);*/
		
		
		
		
		
		
		
	}
	
	void setName()
	{
		
		lb=new JLabel("");
		personaldetails = new JLabel("Personal Details");
		rollno = new JLabel("Roll No : ");
		rollnotxt = new JTextField(14);
		name = new JLabel("Name : ");
		nametxt = new JTextField(14);
		password = new JLabel("Change Password : ");
		passwordtxt = new JPasswordField(14);
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
		lb1 = new JLabel("");
		paymentdetails = new JLabel("Wallet Details");
		balance = new JLabel("Add Money : ");
		bal = new JLabel("Current Wallet Balance : ");
		baltxt = new JTextField(14);
		update = new JButton("UPDATE");
		
	}
	
	void setLocation()
	{
		
		lb.setBounds(30, 0,600, 440);
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
		
		password.setBounds(50, 150, 200, 30);
		password.setFont(new Font("Arial",Font.BOLD,15));
		
		passwordtxt.setBounds(250, 150, 200, 30);
		passwordtxt.setFont(new Font("Arial",Font.BOLD,15));
		
		dob.setBounds(50, 190, 200, 30);
		dob.setFont(new Font("Arial",Font.BOLD,15));
		
		eye.setBounds(470, 150, 50, 30);
		
		dd.setSelectedItem("dd");
		dd.setFont(new Font("Arial",Font.PLAIN,15));
		dd.setBounds(250, 190, 50, 30);
		
		mm.setFont(new Font("Arial",Font.PLAIN,15));
		mm.setBounds(310, 190, 50, 30);
		
		yyyy.setFont(new Font("Arial",Font.PLAIN,15));
		yyyy.setBounds(370, 190, 60, 30);
		
		gender.setBounds(50, 230, 200, 30);
		gender.setFont(new Font("Arial",Font.BOLD,15));
		
		male.setBounds(250, 230, 100, 30);
		male.setFont(new Font("Arial",Font.PLAIN,15));
		
		female.setBounds(350, 230, 200, 30);
		female.setFont(new Font("Arial",Font.PLAIN,15));
		
		emailid.setBounds(50, 270, 200, 30);
		emailid.setFont(new Font("Arial",Font.BOLD,15));
		
		emailtxt.setBounds(250, 270, 200, 30);
		emailtxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		mobno.setBounds(50, 310, 200, 30);
		mobno.setFont(new Font("Arial",Font.BOLD,15));
		
		mobnotxt.setBounds(250, 310, 200, 30);
		mobnotxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		dept.setBounds(50, 350, 200, 30);
		dept.setFont(new Font("Arial",Font.BOLD,15));
		
		stream.setBounds(250, 350, 200, 30);
		stream.setFont(new Font("Arial",Font.BOLD,15));
		
		year.setBounds(50, 390, 200, 30);
		year.setFont(new Font("Arial",Font.BOLD,15));
		
		deptname.setBounds(250, 390, 200, 30);
		deptname.setFont(new Font("Arial",Font.BOLD,15));
		
		lb1.setBounds(30, 450,600, 150);
		lb1.setBorder(new LineBorder(Color.BLUE));
		
		paymentdetails.setBounds(50, 470, 200, 30);
		paymentdetails.setFont(new Font("Arial",Font.BOLD,18));
		
		bal.setBounds(50, 520, 200, 30);
		bal.setFont(new Font("Arial",Font.BOLD,15));
		
		add.setBounds(250, 560, 200, 30);
		add.setFont(new Font("Arial",Font.BOLD,15));
		
		balance.setBounds(50, 560, 200, 30);
		balance.setFont(new Font("Arial",Font.BOLD,15));
		
		baltxt.setBounds(250, 520, 200, 30);
		baltxt.setFont(new Font("Arial",Font.PLAIN,15));
		
		update.setBounds(250, 630, 100, 25);
		update.setFont(new Font("Arial",Font.BOLD,15));
		
	}
	
	void addComponent()
	{
		lb.add(personaldetails);
		lb.add(rollno);
		lb.add(rollnotxt);
		lb.add(name);
		lb.add(nametxt);
		lb.add(password);
		lb.add(passwordtxt);

		add(eye);
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
		
		lb.add(deptname);
		lb.add(stream);
		add(lb);
		
		lb.add(year);
		
		
		add(paymentdetails);
	
		
		
		add(add);
		
		add(bal);
		
		add(balance);
		
		add(lb1);
		
		
		add(baltxt);
		
		add(update);
		
	}
	
	void setCursor()
	{
		
		eye.setCursor(Password.curr);
	
		dd.setCursor(Password.curr);
	
		mm.setCursor(Password.curr);
	
		yyyy.setCursor(Password.curr);
		
		
		male.setCursor(Password.curr);
			
		female.setCursor(Password.curr);
	
		dept.setCursor(Password.curr);
		
		deptname.setCursor(Password.curr);
		
		stream.setCursor(Password.curr);
		
		add.setCursor(Password.curr);
		update.setCursor(Password.curr);
			
	}
	
	void addListener()
	{
		update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent a) {
				try{
					validateMobile(mobnotxt.getText());
					validateEmail(emailid.getText());
				
				JOptionPane.showMessageDialog(new JFrame()," Details Updated Successfully.");
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(new JFrame(),"    Invalid Details  ");
				}
				
			}
		});
	}
	
	void setPassword()
	{
		eye.setIcon(icon);
		Password.showpasswrd(eye, passwordtxt);
	}
	
	public void validateMobile(String str) throws Exception
	{
		Long a;
		 a=Long.parseLong(str);
		if(str.length()>10 || a<0)
			throw new NumberFormatException();

	}
	
	public void validateEmail(String str) throws Exception{
		int a=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='@')
				a=1;
			if(a==1 && str.substring(i).equals(".com"))
				return ;		
		}
		throw new Exception();
		}
}