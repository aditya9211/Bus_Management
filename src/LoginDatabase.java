import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LoginDatabase {

	   
	   private String username;
	   private int password;
	   public LoginDatabase(String username,int password){
		   this.username=username;
		   this.password=password;
	   }
	   
	   public boolean userInitialise()  {
		   
		   try{
			   String sql;
			   sql="Select rollno,password From student";
			   ResultSet rs= Database.stmt.executeQuery(sql);
			   while(rs.next()){
				   String r=rs.getString("rollno");
				   int p=Integer.parseInt(rs.getString("password"));
				   if(r.equals(username) && password==p)
					   return true;   
			   }
			   
		   }
		   
		   catch(SQLException s){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered");
		   }
		   
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured");
		   }
		 
		   return false;   
	   }
	   
	   
 public boolean adminIntialise()  {
		   
		   try{
			   String sql;
			   sql="Select RollNumber,Password From admin";
			   ResultSet rs= Database.stmt.executeQuery(sql);
			   while(rs.next()){
				   String r=rs.getString("RollNumber");
				   String p=rs.getString("Password");
				   if(r.equals("RollNumber") && p.equals("Password"))
					   return true;
				   
			   }
		   }
		   catch(SQLException s){
			   JOptionPane.showMessageDialog(new JFrame("SQLException"), "SQLException has occuered");
		   }
		   catch(Exception e){
			   JOptionPane.showMessageDialog(new JFrame("Error Occured"),"System error has Occured");
		   }
		 
		   return false;   
	   }
}
