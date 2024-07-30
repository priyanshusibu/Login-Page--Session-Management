package logic.controller;
import  logic.bean.*;
import  logic.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.StringConcatFactory;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out =response.getWriter();	
      response.setContentType("text/html");
      String name=(String)request.getParameter("full_name");
      String email=(String)request.getParameter("email");
      String user_name=(String)request.getParameter("username");
      String password=(String)request.getParameter("password");
      String country=(String)request.getParameter("country");
      String mobile=(String)request.getParameter("phone");
      String age=(String)request.getParameter("age");
      User user=new User();
      user.setName(user_name);
      user.setAge(age);
      user.setCountry(country);
      user.setEmail(email);
      user.setMobile(mobile);
      user.setPassword(password);
      user.setUser_name(user_name);
      int k=Operation.insert(user);
      if(k==1)
      {
    	out.println("<div style='color: green; font-weight: bold;'>Register Successfully</div>"); 
    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
    	rd.include(request, response);
      } else {
    	  out.println("<div style='color: red; font-weight: bold;'>Register Not Successfully</div>");
      	RequestDispatcher rd=request.getRequestDispatcher("signup.jsp");
      	rd.include(request, response);
	}
		
	}

}
