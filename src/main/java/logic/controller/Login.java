package logic.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.bean.User;
import logic.dao.Operation;
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String  user_name=request.getParameter("uname");
		String password=request.getParameter("password");
		User user=new User();
		user.setUser_name(user_name);
		user.setPassword(password);
	   String check=Operation.fatch_data(user);
	   System.out.println(check);
	    if (check.equals("success")) {
				 System.out.println("11");
				 User usr=Operation.fatch_infromationUser(user_name, password);
				 HttpSession session=request.getSession();
				 session.setAttribute("user_session", usr);
				 RequestDispatcher rd=request.getRequestDispatcher("profileInfo.jsp");
				 rd.forward(request, response);
	    }else if (check.equals("invalid password")) {
	    	//out.print("Invalid Password Entered");
	    	HttpSession session=request.getSession();
	    	session.setAttribute("key1","invalid password");
	    	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	    	rd.forward(request, response);
		}else {
			out.print("Invalid user name Entered ");
			HttpSession session=request.getSession();
	    	session.setAttribute("key1","Invalid User Name");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}



