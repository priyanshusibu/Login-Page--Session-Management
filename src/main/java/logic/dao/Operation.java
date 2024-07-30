package logic.dao;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.env.IRecordComponent;

import logic.bean.User;
public class Operation {
	public static int insert(User b)
	  {
		int k=0;
		try {
			Connection connection=DB_Con.getConnection();
			String name=b.getName();
			String email=b.getEmail();
			String age=b.getAge();
			String mob=b.getMobile();
			String country=b.getCountry();
			String u_name=b.getUser_name();
			String password=b.getPassword();
			
			String sql="INSERT INTO user(full_name,email,age,mob,country,user_name,password) VALUES (?,?,?,?,?,?,?)";
		    PreparedStatement ps=connection.prepareStatement(sql);
		    ps.setString(1,name);
		    ps.setString(2, email);
		    ps.setString(3, age);
		    ps.setString(4, mob);
		    ps.setString(5,country);
		    ps.setString(6,u_name);
		    ps.setString(7, password);
		    k=ps.executeUpdate();
		    
		} catch (Exception e) {
			System.out.println("Exception insert table logic on here :"+e);
 		    return k;
		}
		return k;
	  }
	
	  public static  String  fatch_data(User b) 
	  {
		String user_name=b.getUser_name();
		String password=b.getPassword();
		User user=new User();
		try {
			String sql="SELECT * FROM user  WHERE user_name = ? ";
			Connection con=DB_Con.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,user_name);
		    ResultSet rSet=ps.executeQuery();
		    if (rSet.next()) {
		    	System.out.println(rSet.getString(8));
		    	if (password.equals(rSet.getString(8))) {
					return "success";
				}else {
					return "invalid password";
				}
			}else {
			   System.out.println("No Such Record Found ");
			   return "invalid user";
			}
		} catch (Exception e) {
			//
			System.out.println("Exception in the fatch data block :"+e);
			return null;
		}
	  }
	  
	  public static User fatch_infromationUser(String uname,String pass)
	  {
		  User user=new User();
		  try {
				Connection con=DB_Con.getConnection();
				String sql="SELECT * FROM user WHERE user_name = '"+uname+"' AND password = '"+pass+"'";
                PreparedStatement ps=con.prepareStatement(sql);
                ResultSet rSet=ps.executeQuery();
                if (rSet.next()) {
					user.setName(rSet.getString(2));
					user.setEmail(rSet.getString(3));
					user.setAge(rSet.getString(4));
					user.setMobile(rSet.getString(5));
					user.setCountry(rSet.getString(6));
					user.setUser_name(rSet.getString(7));
					user.setPassword(rSet.getString(8));
				}
                } catch (Exception e) {
                	System.out.println("You have error in the fatching information section :"+e);
			// TODO: handle exception
		}
		return user;
	  }
	  public static boolean checkEmailname(String email) 
	  {
		String sql="SELECT email FROM user WHERE email = '"+email+"'";
		try {
			Connection connection=DB_Con.getConnection();
			Statement statement=connection.createStatement();
			String mail=null;
			ResultSet rSet=statement.executeQuery(sql);
			if (rSet.next()) {
				 mail=rSet.getString(1);
			}
			if (email.equals(mail)) {
				System.out.println("Email Fatched");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Excepton in checking  the email "+e);
			return false;
		}
		return false;
	}
	public static boolean changePasswor(String email,String newPassword) {
        String sql="UPDATE user SET password = '"+newPassword+"' WHERE email ='"+email+"'";
		try {
			Connection con=DB_Con.getConnection();
			Statement st=con.createStatement();
			int k=st.executeUpdate(sql);
			if (k>=0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		    System.out.println("Exception in the forgot password code");
		    return false;
		}
	}
}
