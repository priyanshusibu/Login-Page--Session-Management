package logic.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.dao.Operation;

/**
 * Servlet implementation class Forgot
 */
@WebServlet("/Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
     
		String email=request.getParameter("email");
		if (Operation.checkEmailname(email)) {
			request.setAttribute("eml", email);
			RequestDispatcher rDispatcher=request.getRequestDispatcher("reset_password.jsp"); 
			rDispatcher.forward(request, response);
		}else {
			out.print("Invalid Password Entered");
			RequestDispatcher rd=request.getRequestDispatcher("forgot.jsp"); 
			rd.include(request, response);
		}
	}

}
