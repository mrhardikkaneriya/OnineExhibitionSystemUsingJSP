package forgetpassword;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

import MYUtil.MYUtil;
import MailSMTP.Services;
//import jpc.Services;
/**
 * Servlet implementation class ForgetPassword
 */
@WebServlet("/ForgetPassword")
public class ForgetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPassword() {
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
		
		
		String email=request.getParameter("email");
		System.out.println(email);
		 //String jdbcURL = "jdbc:mysql://localhost:3306/exhibition";
	     //String jdbcUsername = "root";
	     //String jdbcPassword = "root";
		char[] msg1 = null;
		int selectRow = 0;
		int len=4;
		char[] otp = new char[len];
		String str="Invalid";
		char []msg=str.toCharArray();
		Connection con=MYUtil.CreateConnection();
        //Class.forName("com.mysql.jdbc.Driver");
        //Connection  cn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	   //selectRow=dao.getUser(connection,email);
		String forgetPassQuery_h="select * from host_registration where host_mail=?";
		String forgetPassQuery_v="select * from viewer_registration where viewer_mail=?";

		int selectedRow=0;
		try
		{
			//host
			PreparedStatement ps = con.prepareStatement(forgetPassQuery_h);
			ps.setString(1, email);
			ResultSet resultset=(ResultSet) ps.executeQuery();
			if(resultset != null)
			{
				try
				{
					while(resultset.next()) 
					{
						selectedRow=resultset.getInt(1);
						selectRow=selectedRow;
						break;
					}
				}	
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
			
			
			//Viewer
			ps = con.prepareStatement(forgetPassQuery_v);
			ps.setString(1, email);
			resultset=(ResultSet) ps.executeQuery();
			
			if(resultset != null)
			{
				try
				{
					while(resultset.next()) 
					{
						selectedRow=resultset.getInt(1);
						selectRow=selectedRow;
						break;
					}
				}	
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(selectRow>0)
		{
			String numbers = "0123456789";
			Random rndm_method=new Random();
			
			for(int i=0;i<len;i++)
			{
				otp[i]=numbers.charAt(rndm_method.nextInt(numbers.length()));
			}
			//return otp;
			msg1=otp;
			//break;
			
		}
		else
		{
			msg1=msg;
		} 
		//msg1=otp;
		String str1 = String.valueOf(msg1);
		System.out.println(str1);
		if(str1.equalsIgnoreCase("Invalid"))
		{
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("unsuccess.jsp");
			requestDispatcher.forward(request, response);
		}
		else
		{
			try 
			{
				Services.sendMailViaOTP(email, str1);
				request.setAttribute("email", email);
				request.setAttribute("str", str1);
				//response.sendRedirect("VerifyOtp.jsp");
				
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("EnterOTP.jsp");
				requestDispatcher.forward(request, response);
				
				
			}
			catch (Exception e) {
				System.out.println("Mail sending failed!");
			}
		}
	}
}