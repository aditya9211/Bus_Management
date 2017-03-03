import java.awt.event.*;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView.TableRow;

public class BusDetail  extends JFrame{
	
	Font fon;
	JLabel from,to,date,time,bus;
	JComboBox From,To,Date,Time;
	JPanel panel1,panel2;
	Calendar cal;
	JButton ok;
	JTable table;
	JScrollPane scroll;
	private String[] places2={"LNMIIT"};
	private String[] places={"Ajmeri Gate","Pink Square","Raja Park","RBI","LNMIIT"};
	private String[] places1={"Ajmeri Gate","Pink Square","Raja Park","RBI"};
	private String[] times1={"7 AM","8 AM","12 AM","2:15 PM"};
	private String[] times2={"4 PM","7 PM","8 PM"};
	String[] times={"7 AM","8 AM","12 AM","2:15 PM","4 PM","7 PM","8 PM"};
	public BusDetail(){
				
		intitialise();
		setFrame();
		setDate();
		setTable();
		setLocation();
		addElement();
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		combo c=new combo();
		From.addItemListener(c);
		
	}
	
	public void setLocation(){
		panel1.setBounds(0,0,300,200);
		panel2.setBounds(300,200,300,300);
		from.setBounds(100,20,70,20);
		From.setBounds(200,20,120,20);
		to.setBounds(100,60,70,20);
		To.setBounds(200,60,120,20);
		time.setBounds(100,100,70,20);
		Time.setBounds(200,100,120,20);
		date.setBounds(100,140,70,20);
		Date.setBounds(200,140,120,20);
		ok.setBounds(150,180,70,30);
		bus.setBounds(130,230,100,19);
		scroll.setBounds(20,20,400,200);

	}
	
	public void intitialise(){
		fon=new Font("Arial",Font.BOLD,17);
		
		from=new JLabel("From : ");
		to=new JLabel("To : ");
		time=new JLabel("Time");
		date=new JLabel("Date");
		From=new JComboBox(places);
		To=new JComboBox(places2);
		Time=new JComboBox(times);
		cal=Calendar.getInstance();
		ok=new JButton("Ok");
		
		bus=new JLabel("Bus Data",SwingConstants.CENTER);
		bus.setFont(fon);
		
		panel2=new JPanel();
		panel1=new JPanel();
		table=new JTable(100,4);
	
		scroll=new JScrollPane(table);
	}
	
	public void setDate(){
		String[] days=new String[5];
		for(int i=0;i<5;i++){
			days[i]=new String(""+ cal.get(Calendar.DATE)+" / " +  cal.get(Calendar.MONTH)+" / "+ cal.get(Calendar.YEAR));
			cal.add(Calendar.DATE, 1);
		}
		Date=new JComboBox(days);
	}
	public void addElement(){

		panel1.add(from);
		panel1.add(From);
		panel1.add(to);
		panel1.add(To);
		panel1.add(time);
		panel1.add(Time);
		panel1.add(date);
		panel1.add(Date);
		panel1.add(ok);
		panel1.add(bus);
		add(panel1);
		panel2.add(scroll);
		add(panel2);
	}
	
	public void setTable(){
		table.setPreferredScrollableViewportSize(new Dimension(700,150));
		Object[] tab={"FROM","TO","Time","Date"};
		TableColumn column;
		for(int i=0;i<4;i++)
		{
			column=table.getColumnModel().getColumn(i);
			column.setPreferredWidth(300);
			column.setHeaderValue(tab[i]);
		}
		table.setRowHeight(30);
	}
	
	public void setFrame(){
		setLayout(new GridLayout(2,1));
		panel1.setLayout(null);
		panel2.setLayout(null);
	}
	
	public class combo implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			String str=e.getItem().toString();
			if(str.equals("LNMIIT") )
			{	
				DefaultComboBoxModel model = new DefaultComboBoxModel(places1);
				To.setModel(model);
				model=new DefaultComboBoxModel(times1);
				Time.setModel(model);
			}
			else if(str.equals("Ajmeri Gate") || str.equals("Pink Square") || str.equals("Raja Park") || str.equals("RBI"))
			{
				DefaultComboBoxModel model = new DefaultComboBoxModel(places2);
				To.setModel(model);
				model=new DefaultComboBoxModel(times2);
				Time.setModel(model);
			}
		}
		
	}
	
	public static void main(String arfs[]){
		BusDetail b=new BusDetail();
	}
	
	
	
}
