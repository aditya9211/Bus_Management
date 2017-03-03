import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class BusDetails extends JPanel{
	
	JLabel from , to , date , time ,bus,lb;
	JComboBox From , To , dd,mm,yyyy,timedetails;
	JTable bustable;
	JScrollPane scpane;
	Cursor cur = new Cursor(Cursor.HAND_CURSOR);
	
	private String[] places2={"LNMIIT"};
	private String[] places={"Ajmeri Gate","Pink Square","Raja Park","RBI","LNMIIT"};
	private String[] places1={"Ajmeri Gate","Pink Square","Raja Park","RBI"};
	private String[] times1={"7 AM","8 AM","12 AM","2:15 PM"};
	private String[] times2={"4 PM","7 PM","8 PM"};
	private String day[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String month[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private String years[] = {"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001"};
	String tim[] = {"","","","","","","","","","","",""};
	public BusDetails()
	{
		setLayout(null);
		initialise();
		lb.setLayout(null);
		lb.setBorder(new LineBorder(Color.BLUE));
		setLocation();
		setfont();
		setCursor();
		addElement();
		combo c=new combo();
		From.addItemListener(c);		
	
	}
	
	public void initialise(){
	    lb=new JLabel("");
	    from = new JLabel("From : ");
	    From=new JComboBox(places);
	    to = new JLabel("To : ");
	    To=new JComboBox(places2);
		date = new JLabel("Date : ");
		dd = new JComboBox(day);
		mm = new JComboBox(month);
		yyyy = new JComboBox(years);
		time = new JLabel("Time : ");
		timedetails = new JComboBox(tim);
		bus = new JLabel("Buses : ");
		bustable = new JTable(100,5);
		scpane = new JScrollPane(bustable);
	}
	
	public void setLocation(){
		lb.setBounds(70, 10,700, 500);
		from.setBounds(130,40,200,30);
		From.setBounds(350,40,200,30);
		to.setBounds(130,80,200,30);
		To.setBounds(350,80,200,30);
		dd.setBounds(350, 120, 50, 30);
		mm.setBounds(410, 120, 50, 30);
		yyyy.setBounds(470, 120, 60, 30);
		date.setBounds(130,120,200,30);
		time.setBounds(130,160,200,30);
		timedetails.setBounds(350, 160, 100, 30);
		bus.setBounds(130, 210, 200, 30);
		scpane.setBounds(110, 240, 500, 200);
	}
	
	public void addElement(){
		add(lb);
		lb.add(from);
		lb.add(From);
		lb.add(to);
		lb.add(To);
		lb.add(date);
		lb.add(dd);
		lb.add(mm);
		lb.add(yyyy);
		lb.add(timedetails);
		lb.add(time);
		lb.add(bus);
		lb.add(scpane);
		
	}
	
	public void setCursor(){
		From.setCursor(cur);
		To.setCursor(cur);
		dd.setCursor(cur);
		mm.setCursor(cur);
		yyyy.setCursor(cur);
		timedetails.setCursor(cur);
	}
	
	public void setfont(){
		
		from.setFont(new Font("Arial",Font.BOLD,15));
		From.setFont(new Font("Arial",Font.PLAIN,15));
		to.setFont(new Font("Arial",Font.BOLD,15));
		dd.setFont(new Font("Arial",Font.PLAIN,15));
		yyyy.setFont(new Font("Arial",Font.PLAIN,15));
		time.setFont(new Font("Arial",Font.BOLD,15));
		mm.setFont(new Font("Arial",Font.PLAIN,15));
		date.setFont(new Font("Arial",Font.BOLD,15));
		timedetails.setFont(new Font("Arial",Font.PLAIN,15));
		To.setFont(new Font("Arial",Font.PLAIN,15));
		bus.setFont(new Font("Arial",Font.BOLD,16));
	}
	
	public class combo implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent e) {
			String str=e.getItem().toString();
			if(str.equals("LNMIIT") )
			{	//To.hide();
				DefaultComboBoxModel model = new DefaultComboBoxModel(places1);
				To.setModel(model);
				model=new DefaultComboBoxModel(times1);
			}
			else if(str.equals("Ajmeri Gate") || str.equals("Pink Square") || str.equals("Raja Park") || str.equals("RBI"))
			{
				DefaultComboBoxModel model = new DefaultComboBoxModel(places2);
				To.setModel(model);
				model=new DefaultComboBoxModel(times2);
			}
		}
		
	}
}