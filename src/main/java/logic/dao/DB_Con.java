package logic.dao;
import  java.sql.*;
public class DB_Con {
    public static Connection getConnection() throws Exception {
    	   System.out.println("Enterd in the getConnectionmethod");
		   Class.forName("com.mysql.cj.jdbc.Driver");
		   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_mvc","root","Meher@123");	
		    return con;
		  
	} 
}
