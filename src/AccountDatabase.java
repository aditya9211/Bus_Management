
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.*;
public class AccountDatabase{
	
	   
	   private ResultSet rs;
	   private String username;
	   
	   
	   public AccountDatabase(String username){
		   this.username=username;
		   try{
			   
		   }
		   catch(Exception e){
			   
			   JOptionPane.showMessageDialog(new JFrame(""), "Could not create conncection");
		   }
	   }
	   
	   public void userInitialise(StudentDetails s)  {
		   
		   try{
			  
			   String sql;
			   
			   sql="select name,rollno,mobileno,emailid,dept,year,gender,dob from student where rollno='"+username+"'";
			   rs= Database.stmt.executeQuery(sql);	
			   while(rs.next()){
			   s.Name.setText(rs.getString("name"));
			   if(new String("F").equals(rs.getString("gender")))
				   s.female.setSelected(true);
			   else
				   s.male.setSelected(true);
			   
			   s.female.setEnabled(false);
			   s.male.setEnabled(false);
			   s.DOB_Text.setText(rs.getString("dob"));
			   s.Dept.setText(rs.getString("dept"));
			   int a=rs.getInt("year");
			   if(a==1)
				   s.Year.setText("First Year");
			   else if(a==2)
				   s.Year.setText("Second Year");
			   else if(a==3)
				   s.Year.setText("Third Year");
			   else if(a==4)
				   s.Year.setText("Fourth Year");
			   
			   s.RollNo.setText(rs.getString("rollno"));
			   s.MobileNo.setText(rs.getString("mobileno"));
			   s.EmailId.setText(rs.getString("emailid"));
			   }	
				
			  
		   }
		   catch(SQLException a){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+a);
		   }
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
		   }
	   }
	   
	   public void userBal(balance b)  {   
		   try{
			   String sql;
			   sql="select balance from student where rollno='"+username+"'";
			   ResultSet rs;
			  rs= Database.stmt.executeQuery(sql);
			  while(rs.next()){
				   
			   String bal=String.valueOf(rs.getInt("balance"));
			   b.Bal.setText(bal);
			   }

			  sql="select busdetails.source,busdetails.destination,busdetails.time,busdetails.day from book_bus , busdetails where busdetails.bus_id=book_bus.bus_id and book_bus.rollno='"+username+"' order by busdetails.day desc";
			  rs= Database.stmt.executeQuery(sql);
			   int row=0;
				
			   b.table.setEnabled(true);
				while(rs.next()){
					
					b.table.setValueAt((Object)rs.getString("busdetails.source"),row , 0);
					b.table.setValueAt((Object)rs.getString("busdetails.destination"),row,1);
					b.table.setValueAt((Object)rs.getString("busdetails.time"),row , 2);
					b.table.setValueAt((Object)rs.getString("busdetails.day"),row , 3);
					row++;
				}
				b.table.setEnabled(false);
			}
		   catch(SQLException a){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+a);
		   }
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
		   }
	   }
 
	   public int getBalance()  {   
		   int bal=0;
		   try{
			   String sql;
			   sql="select balance from student where rollno='"+username+"'";
			   
			  ResultSet rs= Database.stmt.executeQuery(sql);
			  while(rs.next()){
			   bal=rs.getInt("balance");
			   }
			  
			}
			  catch(SQLException a){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+a);
		   }
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
		   }
		   return bal;
	   }
	   
	   public void setData(int b,balance bal) throws Exception {
		   String sql;
			   sql="Update student set balance="+b+" where rollno='"+username+"'";
			   Database.stmt.executeUpdate(sql);
			   bal.Bal.setText(String.valueOf(b));
		   
		
	   }
	   
	   
          public void updateAccount(String[] splited)  {
		   
		   try{

			   String sql;
			   int a=1;
			   if(splited[4].equals("First"))
			   		a=1;
			   else if(splited[4].equals("Second"))
			   	a=2;
			   	else if(splited[4].equals("Third"))
			   	a=3;
			   	else if(splited[4].equals("Fourth"))
			   	a=4;
			   sql="Update student set mobileno='"+splited[0]+"',emailid='"+splited[1]+"',dept='"+splited[2]+" "+splited[3]+"',year="+a+" where rollno='"+username+"'";
			   Database.stmt.executeUpdate(sql);
			   JOptionPane.showMessageDialog(new JFrame("Message"), "Your changes ha been saved");
		   }
		   catch(SQLException e){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+e);
		   }
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
		   }

	   }
          
          public void updateTrip(String[] splited,int balance ,balance b)  {
   		   
   		   try{
   			   ResultSet rs;
   			   String sql;
   			
			   b.Bal.setText(String.valueOf(balance));
   			   sql="select bus_id ,seats_booked from busdetails where source='"+splited[0]+"'and destination='"+splited[1]+"'and time='"+splited[2]+" "+splited[3]+"'"+"and day='"+splited[4]+"'";
   			
   			   rs=Database.stmt.executeQuery(sql);
   			   
   			   
   			   
   			   rs.next();
   			   
   			 if(rs.getInt("seats_booked")>50)
		   			throw new Exception();
   			   sql="insert into book_bus(rollno,bus_id) Values('"+username+"',"+rs.getInt("bus_id")+")";
   			   
   			  
   			   Database.stmt.execute(sql);
   		
   			   sql="Update student set balance="+balance+" where rollno='"+username+"'";
			   Database.stmt.executeUpdate(sql);
			   
   		   }
   		   catch(SQLException e){
   			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+e);
   		   }
   		   catch(Exception e){
   			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
   		   }
   		 
   	   }
          
          public void updatePass(int CurrPassword,int NewPassword){
        	  
        	   try{
       			   String sql;
       			   int password=0;
       			   sql="select password from student where rollno='"+username+"'";
       			   rs=Database.stmt.executeQuery(sql);
       			   while(rs.next()){
       				   
       			    password=Integer.parseInt(rs.getString("password"));
       			   }
       			   if(password==CurrPassword){ 
       				   sql="Update student set password='"+NewPassword+"'where rollno='"+username+"'";
       				   Database.stmt.executeUpdate(sql);
       			   }
       			   else JOptionPane.showMessageDialog(new JFrame("Invalid password"), "Please retype your password");
       			   
       		   }
       		   catch(SQLException e){
       			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered"+e);
       		   }
       		   catch(Exception e){
       			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured"+e);
       		   }
          }
          
         
         
}
