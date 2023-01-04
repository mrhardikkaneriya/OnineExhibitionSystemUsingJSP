package payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.Event;
import login.User;
import order.OrderDAO;

/**
 * Servlet implementation class StorePaymentDetailsServlet
 */
@WebServlet("/StorePaymentDetailsServlet")
public class StorePaymentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StorePaymentDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String t_id = request.getParameter("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		int res = PaymentDAO.save(t_id, amount);
		
		
		if(res>0) 
		{
			//PaymentDAO.updateProducts()
			
			Payment p = new Payment();
			System.out.println("Event ID in payment "+p.getE_id());
			int r = PaymentDAO.UpdateProductPaymentById(p.getE_id());
			
			if(r==0) {
				int ore_res = OrderDAO.save(t_id);
			}
			
			response.sendRedirect("index.jsp");
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
