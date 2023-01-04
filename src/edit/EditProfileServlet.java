package edit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.User;
import registration.Registration;
import registration.RegistrationDAO;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
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
		
		
		String type=request.getParameter("type");
		Registration reg=new Registration();
		System.out.println("In update Profile Servlet "+type);
		int update_status=0;
		//int id=0;
		String id,name, mail,contact, password, gender;
		if(type.equalsIgnoreCase("Host"))
		{
			System.out.println("In update Profile Servlet HostCase");
			id=request.getParameter("u_id");
			name=request.getParameter("username");
			mail=request.getParameter("email");
			contact=request.getParameter("contact");
			gender=request.getParameter("gender");
			password=request.getParameter("password");
			
			
			reg.setHost_id(Integer.parseInt(id));
			reg.setName(name);
			reg.setEmail(mail);
			reg.setContact(contact);
			reg.setGender(gender);
			reg.setPassword(password);
			
			System.out.println("Set Value");
			update_status=RegistrationDAO.update(reg);
		}
		if(type.equalsIgnoreCase("Viewer"))
		{
			id=request.getParameter("u_id");
			name=request.getParameter("username");
			mail=request.getParameter("email");
			contact=request.getParameter("contact");
			password=request.getParameter("password");
			gender=request.getParameter("gender");
			
			
			reg.setViewer_id(Integer.parseInt(id));
			reg.setName(name);
			reg.setEmail(mail);
			reg.setContact(contact);
			reg.setPassword(password);
			reg.setGender(gender);
			
			update_status=RegistrationDAO.updateViewer(reg);
		}
		
		System.out.println("Status "+update_status);
		if(update_status>0)
		{
			response.sendRedirect("host_profile_page.jsp");
		}
		else
		{
			System.out.println("Sorry. Unable to update");
		}
	}

}
