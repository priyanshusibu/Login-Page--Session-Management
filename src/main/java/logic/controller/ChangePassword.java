package logic.controller;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.dao.Operation;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String e =(String)request.getAttribute("eml");
		    String oldPassword=request.getParameter("old_password");
			String confirmPassword=request.getParameter("confirm_password");
			Boolean b=Operation.changePasswor(e, confirmPassword);
			if (b) {
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				System.out.println(" Password Updated Successfully");
				rd.forward(request, response);
			}else {
				System.out.println("Updated Unccessfully");
			}
	}

}
