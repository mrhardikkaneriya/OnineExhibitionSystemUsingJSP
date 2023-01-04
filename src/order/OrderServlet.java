package order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
//		int eve_id = Integer.parseInt(request.getParameter("event_id"));
		int pro_id = Integer.parseInt(request.getParameter("product_id"));
		int pro_value = Integer.parseInt(request.getParameter("product_amount"));
		String ord_add = request.getParameter("order_add");
		
				
		User user = new User();
		String user_typ = user.getUser_type();
		int user_id = 0;
		if(user_typ.equalsIgnoreCase("HOST")) {
			user_id = user.getHost_id();
		}else if(user_typ.equalsIgnoreCase("VIEWER")) {
			user_id = user.getViewer_id();
		}
		
		HttpSession s1 = request.getSession();
		s1.setAttribute("total_amount", pro_value);
		
		Order or = new Order();
		or.setPro_id(pro_id);
		or.setOrd_add(ord_add);		
		
		
		if(user_typ.equalsIgnoreCase("HOST")){
			response.sendRedirect("TxnTest.jsp?type=Host");
		}else if(user_typ.equalsIgnoreCase("VIEWER")) {
			response.sendRedirect("TxnTest.jsp?type=Viewer");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);		
	}

}
