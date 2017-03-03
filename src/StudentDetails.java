import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


import org.apache.commons.validator.routines.EmailValidator;
public class StudentDetails extends JPanel implements ActionListener {
	JTextField Name,RollNo,MobileNo,EmailId,index,Year,Dept,DOB_Text;
	JLabel name,rollno,gender,mobileno,emailid,deptno,year;
	JRadioButton male,female;
	ButtonGroup bg;
	JPanel panel1,Gender;
	Font font;
	JButton Save;
	Account a;
	JComboBox department,YEAR;
	public StudentDetails(Account a)	{
		this.a=a;
		this.setLayout(new GridBagLayout());
	    GridBagConstraints c=new GridBagConstraints();
	    
	    font =new Font("Arial",Font.BOLD,14);
	    Year=new JTextField(20);
	    Dept=new JTextField(20);
	    
	    String[] depart={"...","CSE","ECE","CCE","MME","MTech","PHD"};
	    String[] y={"...","I","II","III","IV"};
	    department=new JComboBox<>(depart);
	    YEAR=new JComboBox<>(y);
	    
		Year=new JTextField(20);
		Dept=new JTextField(20);
		Year.setEditable(false);
		Dept.setEditable(false);
		department.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				String str=arg0.getItem().toString();
				if(str.equals("CSE"))
					Dept.setText("Computer Science");
				else if(str.equals("ECE"))
					Dept.setText("Electronics and Communication");
				else if(str.equals("MME"))
					Dept.setText("Mechanical and mechatrobics");
				else if(str.equals("CCE"))
					Dept.setText("Computer and Communication");
			}
		});
		YEAR.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				String str=e.getItem().toString();
				if(str.equals("I"))
					Dept.setText("First Year");
				else if(str.equals("II"))
					Dept.setText("Secnind Year");
				else if(str.equals("III"))
					Dept.setText("third Year");
				else if(str.equals("IV"))
					Dept.setText("Fourth Year");
				
			}
		});
		
		DOB_Text=new JTextField(20);
		DOB_Text.setEditable(false);
		
		bg=new ButtonGroup();
		
		
		male=new JRadioButton("Male");
		male.setActionCommand("Male");
		female=new JRadioButton("Female");
		female.setActionCommand("Female");
		male.enable(false);
		female.enable(false);
		bg.add(male);
		bg.add(female);
		Gender=new JPanel();
		Gender.setLayout(new GridBagLayout());
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(0,-150, 0, 0);
		Gender.add(male,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(0,0, 0, 0);
		Gender.add(female,c);
		
		name=new JLabel("Name : ");
		name.setFont(font);
		rollno=new JLabel("Roll Number : ");
		rollno.setFont(font);
		mobileno=new JLabel("Mobile Number : ");
		mobileno.setFont(font);
		emailid=new JLabel("Email : ");
		emailid.setFont(font);
		deptno=new JLabel("Department Name : ");
		deptno.setFont(font);
		year=new JLabel("Year : ");
		year.setFont(font);
		
		gender=new JLabel("Gender : ");
		gender.setFont(font);
		
		Name=new JTextField(20);
		Name.setEditable(false);
		RollNo=new JTextField(20);
		RollNo.setEditable(false);
		MobileNo=new JTextField(30);
		EmailId=new JTextField(20);
		Save=new JButton("Save");
		index=new JTextField("+91",3);
		index.setText("+91");
		index.setEditable(false);
		panel1=new JPanel();
		panel1.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipady=5;
		c.insets=new Insets(0,0, 0, -0);
		panel1.add(index,c);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(0,0, 0, 0);
		panel1.add(MobileNo,c);
		
		
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(-300,0, 0, 0);
		this.add(name,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		
		c.insets=new Insets(-300,60, 0, 150);
		this.add(Name,c);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(-245,0, 0, 0);
		this.add(rollno,c);
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=1;
		c.insets=new Insets(-245,60, 0, 150);
		this.add(RollNo,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(-185,0, 0, 0);
		this.add(year,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(-185,60, 0, 150);
		this.add(Year,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(-130,0, 0, 0);
		this.add(gender,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=3;
		c.insets=new Insets(-130,60, 0, 150);
		this.add(Gender,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.insets=new Insets(-75,0, 0, 0);
		this.add(mobileno,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=4;
		c.insets=new Insets(-75,60, 0, 150);
		this.add(panel1,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.insets=new Insets(-20,0, 0, 0);
		this.add(emailid,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=5;
		c.insets=new Insets(-20,60, 0, 150);
		this.add(EmailId,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.insets=new Insets(5,0, 0, 0);
		this.add(deptno,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=6;
		c.insets=new Insets(5,60, 0, 150);
		this.add(Dept,c);
		
		c.fill=GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.ipadx=0;
		c.insets=new Insets(5,40, 0,-50);
		this.add(Save,c);
		
		Save.addActionListener(this);
	}
	


	public void actionPerformed(ActionEvent b) {
		try{
			validateMobile(MobileNo.getText());
			validateEmail(EmailId.getText());
			String str= MobileNo.getText()+" "+EmailId.getText()+" "+ Dept.getText() +" "+ Year.getText()+" ";
			a.updateAccount(str);
		}
		catch(NumberFormatException n){
			JOptionPane.showMessageDialog(this, "    Invalid Number Input", "Error",JOptionPane.ERROR_MESSAGE);
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(this, "      Invalid Input", "Error"+e,JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	public void validateMobile(String str) throws Exception
	{
		Long a;
			
		 a=Long.parseLong(str);
		if(str.length()>10 || a<0 || str.length()<10)
			throw new NumberFormatException();

	}
	
	public void validateEmail(String str) throws Exception{
		   try {
			   boolean valid = EmailValidator.getInstance().isValid(str);
			   if(valid==false)
				   throw new Exception();
		   } 
		  finally{
			  
		  }
		   
	}
	
	
	
}
