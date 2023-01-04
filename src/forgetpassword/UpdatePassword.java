package forgetpassword;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYUtil.MYUtil;

/**
 * Servlet implementation class UpdatePassword
 */
@WebServlet("/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
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
		
		//String jdbcURL = "jdbc:mysql://localhost:3306/jobportal";
	    //String jdbcUsername = "root";
	    //String jdbcPassword = "root";
		String email=request.getParameter("email");
		String password=request.getParameter("newpwd");
		//String confirmpassword=request.getParameter("newcnfpwd");
		System.out.println("In update password"+email+"  "+password);
		
		String msg=null;
		//userservice.modifyPassword(password,email);
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");
			// Connection  cn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			Connection con=MYUtil.CreateConnection();
			int updateCount=0;
			
			String updateQueryH="update host_registration set host_password=? where host_mail=?";
			String updateQueryV="update viewer_registration set viewer_password=? where viewer_mail=?";
			
			try
			{
				PreparedStatement ps = con.prepareStatement(updateQueryH);
				ps.setString(1, password);
				ps.setString(2, email);
				updateCount=ps.executeUpdate();
				
				ps = con.prepareStatement(updateQueryV);
				ps.setString(1, password);
				ps.setString(2, email);
				updateCount=ps.executeUpdate();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			if(updateCount>0)
			{
				msg="Password updated successfully";
				System.out.println("Password updated successfully");
				response.sendRedirect("login.jsp");
			}
			else
			{
				msg="Password updated failed";
				System.out.println("Password updated failed");
				response.sendRedirect("login.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} 
	}
}