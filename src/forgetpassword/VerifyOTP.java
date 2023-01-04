package forgetpassword;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerifyOTP
 */
@WebServlet("/VerifyOTP")
public class VerifyOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyOTP() {
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
		
		String original=request.getParameter("verify");
		String validate=request.getParameter("otp");
		String email=request.getParameter("email");
		
		System.out.println("Original "+original);
		System.out.println("Validate "+validate);
		System.out.println("Email "+email);
		if(original.equals(validate))
		{
			System.out.println("Valid otp");
			request.setAttribute("email", email);
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("NewPassword.jsp");
			requestDispatcher.forward(request, response);
			//response.sendRedirect("NewPassword.jsp");
		}
		else
		{
			System.out.println("Invalid otp");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
