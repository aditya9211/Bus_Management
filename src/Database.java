import java.sql.*;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Database {
	
	 private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	 private static final String DB_URL = "jdbc:mysql://localhost:3306/bus";
	  //  Database credentials
	 private static final String USER = "root";
	 private static final String PASS = "hewlett";

	 public static Connection conn=null;
	 public static Statement stmt=null;
	 private String sql;
	 private Calendar cal;
	 public Database()  {
		   
	   try{
		 
		   Class.forName("com.mysql.jdbc.Driver");
		   conn=DriverManager.getConnection(DB_URL,USER,PASS);
		   stmt=conn.createStatement();
		   
		   
/*
		     sql="create table if not exists busdetails(bus_id int not null auto_increment ,source varchar(20),destination varchar(20),time varchar(20),day date,total_seats int,seats_booked int,status int,primary key (bus_id) );";
		     stmt.execute(sql);
		                 
		     sql="create table if not exists admin(password varchar(20));";
		     stmt.execute(sql);
		     sql="create table if not exists student(rollno varchar(20) not null,name varchar(128),password varchar(20),mobileno int,emailid varchar(20),gender char,dept varchar(30),year int,primary key(rollno));";
		     stmt.execute(sql);
		     sql="create table if not exists book_bus(bus_id int,rollno varchar(28),foreign key (bus_id) references busdetails(bus_id),foreign key (rollno) references student(rollno));";
		     stmt.execute(sql);
		                
		     sql="create  table if not exists suggestion(rollno varchar(20),suggestion varchar(400));";
		     stmt.execute(sql);
		      
		     sql="create trigger  decrement_seats before insert on book_bus for each row update busdetails set busdetails.seats_booked=busdetails.seats_booked+1 where busdetails.bus_id=book_bus.bus_id;";
		     stmt.execute(sql);
		     
		     sql="alter table busdetails add constraint stu unique(source,destination,time,day);";
				*/
			
			for(int i=0;i<5;i++)
			{
				cal=Calendar.getInstance();
				sql="Insert ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('Ajmeri_Gate','LNMIIT','7:00 AM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('Ajmeri_Gate','LNMIIT','8:00 AM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('Ajmeri_Gate','LNMIIT','12:00 AM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('Ajmeri_Gate','LNMIIT','2:15 PM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('LNMIIT','Ajmeri_Gate','4:00 PM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('LNMIIT','Ajmeri_Gate','8:00 PM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				sql="Insert Ignore into busdetails(source,destination,time,day,total_seats,seats_booked,status) values('LNMIIT','Ajmeri_Gate','7:00 PM','"+cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE)+"',"+"50,0,1)";
				stmt.execute(sql);
				cal.add(Calendar.DATE, 1);
			}
				
			 
		   }
	   catch(SQLException a){
		   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+a);
	   }
	   catch(Exception e){
		   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
	   }
		   

	   }
	   
/*	   protected void finalize(){
		   try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	*/   
}