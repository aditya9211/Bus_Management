import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Book extends JPanel {
	private JLabel from ,to,time,date;
	private JComboBox From,To,Time,Date;
	private JButton booknow;
	private Calendar cal;
	private int bal;
	private String[] places2={"LNMIIT"};
	private String[] places={"Ajmeri_Gate","Pink_Square","Raja_Park","RBI","LNMIIT"};
	private String[] places1={"Ajmeri_Gate","Pink_Square","Raja_Park","RBI"};
	private String[] times2={"7:00 AM","8:00 AM","12:00 AM","2:15 PM"};
	private String[] times1={"4:00 PM","7:00 PM","8:00 PM"};
	private Account a;
	public Book(int bal,Account a){
		this.a=a;
		this.bal=bal;
		setPanelLayout(null);
		setField();
		setDate();
		setLocation();
		addValues();
		
		combo c=new combo();
		event e=new event();
		From.addItemListener(c);
		booknow.addActionListener(e);
	}
	public void setField(){
		from=new JLabel("From : ");
		to=new JLabel("To : ");
		time=new JLabel("Time");
		date=new JLabel("Date");
		booknow=new JButton("Book");
		Time=new JComboBox(times2);
		From=new JComboBox(places);
		To=new JComboBox(places2);
		cal=Calendar.getInstance();
	}
	
	public void setDate(){
		String[] days=new String[5];
		for(int i=0;i<5;i++)
		{
			char[] mon=new char[2];
			mon[1] = (char)((cal.get(Calendar.MONTH)+1)%10 +'0');
			mon[0] = Integer.toString((cal.get(Calendar.MONTH)+1)/10).charAt(0);

			days[i]=new String(""+ cal.get(Calendar.YEAR)+"-"+mon[0]+mon[1]+"-"+ cal.get(Calendar.DATE));
			cal.add(Calendar.DATE, 1);
		}
		Date=new JComboBox(days);
	}
	
	public void setLocation()	{
		
		from.setBounds(100,20,100,20);
		From.setBounds(200,20,150,20);
		to.setBounds(100,80,100,20);
		To.setBounds(200,80,150,20);
		time.setBounds(100,140,100,20);
		Time.setBounds(200,140,150,20);
		date.setBounds(100,200,100,20);
		Date.setBounds(200,200,150,20);
		booknow.setBounds(125,260,100,20);
	}
	public void addValues(){
		this.add(from);
		this.add(From);
		this.add(to);
		this.add(To);
		this.add(time);
		this.add(Time);
		this.add(date);
		this.add(Date);
		this.add(booknow);
	}
	
	public void setPanelLayout(LayoutManager l)	{
		setLayout(l);
	}
	public class combo implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			String str=e.getItem().toString();
			if(str.equals("LNMIIT") )
			{	//To.hide();
				DefaultComboBoxModel model = new DefaultComboBoxModel(places1);
				To.setModel(model);
				
				DefaultComboBoxModel model1=new DefaultComboBoxModel(times1);
				Time.setModel(model1);
			}
			else if(str.equals("Ajmeri Gate") || str.equals("Pink Square") || str.equals("Raja Park") || str.equals("RBI"))
			{
				DefaultComboBoxModel model = new DefaultComboBoxModel(places2);
				To.setModel(model);
				DefaultComboBoxModel model1=new DefaultComboBoxModel(times2);
				Time.setModel(model1);
			}
		}
		
	}
	
	
	
	public class event implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(bal<25){
				JOptionPane.showMessageDialog(new JFrame("Error in booking"), "    Inefficinet funds in your wallet");
			}
			else{
			
				JOptionPane.showMessageDialog(new Payment("Confirmation",bal,a,From.getSelectedItem()+" "+To.getSelectedItem()+" "+Time.getSelectedItem()+" "+Date.getSelectedItem()),"");
				
			}
		}

	}
}
