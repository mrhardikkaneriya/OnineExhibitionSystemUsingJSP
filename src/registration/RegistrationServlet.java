package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MYUtil.MYUtil;
import login.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		
		String user_type=request.getParameter("type");
		
		String name=request.getParameter("username");
		String mail=request.getParameter("email");
		String pass=request.getParameter("password");
		String cnfpass=request.getParameter("confirmpassword");
		String contact=request.getParameter("contact");
		String gender=request.getParameter("gender");
		
		User u = new User();
		if(pass!=cnfpass) {
			u.setReg_status(1);
			response.sendRedirect("registration.jsp");
		}else {
			u.setReg_status(0);
		}
		
		PrintWriter out = response.getWriter();
		//System.out.println(radio);System.out.println(nm);System.out.println(mail);System.out.println(pass);System.out.println(cnfpass);
		int id=0;
		String email1=null ,pass1=null;
		Registration r=new Registration();
		
		try
		{
			Connection cn=MYUtil.CreateConnection();
			
			if(!(name.isEmpty()||mail.isEmpty()||pass.isEmpty()||cnfpass.isEmpty()))
			{
				System.out.println(user_type);
				String x=user_type;
				System.out.println("X  "+x);
				
				if(x.equals("host"))
				{
					System.out.println("Host found");
		
					 String sql="insert into host_registration(host_name,host_mail,host_contact,host_gender, host_password) values(?,?,?,?,?)";
					 PreparedStatement ps=cn.prepareStatement(sql);
					 
					 ps.setString(1, name);
					 ps.setString(2, mail);
					 ps.setString(3, contact);
					 ps.setString(4, gender);
					 ps.setString(5, pass);
					 ps.executeUpdate();
					
					 response.sendRedirect("login.jsp");
					 System.out.println("HOST SUCCESS...");
				}	
				
				else
				{
					System.out.println("Host found");
					
					 String sql="insert into viewer_registration(viewer_name,viewer_mail,viewer_contact,viewer_gender,viewer_password) values(?,?,?,?,?)";
					 PreparedStatement ps=cn.prepareStatement(sql);
					 
					 ps.setString(1, name);
					 ps.setString(2, mail);
					 ps.setString(3, contact);
					 ps.setString(4, gender);
					 ps.setString(5, pass);
					 ps.executeUpdate();
					
					 response.sendRedirect("login.jsp");
					 System.out.println("VIEW SUCCESS...");
				}
			}
			else
			{
				String message = "Invalid email/password";
				out.println(message);
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("error");
		}
		
		
		
		
		
//		String name=request.getParameter("username");
//		String mail=request.getParameter("email");
//		String pass=request.getParameter("password");
//		String cnfpass=request.getParameter("confirmpassword");
//		
//		PrintWriter out = response.getWriter();
//		System.out.println(name);System.out.println(mail);System.out.println(pass);System.out.println(cnfpass);
//		//int id=0;
//		//String email1=null ,pass1=null;
//		Registration r=new Registration();
//		try
//		{
//			System.out.println("In try");
//			Connection cn=MYUtil.CreateConnection();
//			int id=0;
//			String email1=null;
//			if(!(name.isEmpty()||mail.isEmpty()||pass.isEmpty()||cnfpass.isEmpty()))
//			{
//				String sql="insert into registration_table(db_name,db_email,db_password,db_cnfpwd) values(?,?,?,?)";
//				PreparedStatement ps=cn.prepareStatement(sql);
//				
//				ps.setString(1,name);
//				ps.setString(2,mail);
//				ps.setString(3,pass);
//				ps.setString(4,cnfpass);
//				System.out.println(name+" "+mail+" "+pass+" "+cnfpass);
//					
//				ps.executeUpdate();
//				
//				id=RegistrationDAO.getID(mail);
//				email1=RegistrationDAO.getEmail(id);
//				
//				System.out.println("From DAO" + email1);
//				
//				r.setUser_id(id);
//				r.setName(name);
//				r.setEmail(email1);
//				r.setPassword(pass);
//				
//				System.out.println("Data enterd");
//				response.sendRedirect("login.jsp");
//			}
//			else
//			{
//				String message = "Invalid data";
//				out.println(message);
//			}
//		
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			out.println("error");
//		}
	}
}
