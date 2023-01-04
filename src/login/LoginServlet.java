package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import registration.Registration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String mail=request.getParameter("usermail");
		String password=request.getParameter("password");
		
		UserDAO userdao=new UserDAO();
		String str=null;
		
		try 
		{
			System.out.println("in try");
			User u = new User();
			User user = userdao.checkLogin(mail, password);
//			System.out.println("--User = " + user);
//			System.out.println("in try UT "+user.getUser_type());
			String destPage = null;
			Registration r=null;
			if (user != null)
			{
				u.setLogin_status(0);
				System.out.println("2");
				if(user.getUser_type()=="HOST")
				{
					HttpSession session = request.getSession(); 
					session.setAttribute("user", user);
					System.out.println("Session"+session);
					System.out.println("Session Val????"+user);
					
					System.out.println("H:- "+user.getHost_id()+">>>>>>>>>>>>>>>>>>");
					
					destPage="index.jsp";
					response.sendRedirect(destPage);
				}
				
				else if(user.getUser_type()=="VIEWER")
				{
					HttpSession session = request.getSession(); 
					session.setAttribute("user", user);
					//session.setAttribute("user_id",user.getId());
					System.out.println("V:- "+user.getViewer_name()+" "+user.getViewer_id()+">>>>>>>>>>>>>>>>>>");
					
					destPage="index.jsp";
					response.sendRedirect(destPage);
				}
				
				else if(user.getUser_type()=="ADMIN")
				{
					HttpSession session = request.getSession(); 
					session.setAttribute("user", user);
					System.out.println("Session"+session);
					System.out.println("Session Val????"+user);
					
					System.out.println("A:- "+user.getAdmin_id()+">>>>>>>>>>>>>>>>>>");
					
					destPage="index.jsp";
					response.sendRedirect(destPage);
				}
				else
				{
					destPage="unsuccess.jsp";
					response.sendRedirect(destPage);
				}
				
			}			
			else 
			{		
//				String message = "Invalid email/password";
//				request.setAttribute("message", message);
				
				
				u.setLogin_status(1);
				
//				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//				dis.forward(request, response);
				
				destPage="login.jsp";
				response.sendRedirect(destPage);
			}
			System.out.println("5");
			
		}
		
		catch (SQLException | ClassNotFoundException ex)
		{
			throw new ServletException(ex);
		}	
	}
}