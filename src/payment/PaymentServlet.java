package payment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MYUtil.MYUtil;
import login.User;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		User user=new User();
		String type=user.getUser_type();
		
		int id = Integer.parseInt(request.getParameter("ho_id"));
		int eid = Integer.parseInt(request.getParameter("eventid"));
		System.out.println(id);
		Payment p=new Payment();
		p.setUser_id(id);
		p.setE_id(eid);
		
		
		HttpSession s1=request.getSession();
		HttpSession s2=request.getSession();

		s1.setAttribute("id", id);
		
		int total_amount=PaymentDAO.CountProducts(eid);
		p.setPay_amt(total_amount);
		s2.setAttribute("total_amount", total_amount);
		
		System.out.println(p.getPay_amt());
		if(type.equalsIgnoreCase("Host"))
		{
			response.sendRedirect("TxnTest.jsp?type=Host");
		}

		
		/*Connection cn = MYUtil.CreateConnection();
		

		try {
			String sql = "select count(*) as rowcount from product_table where event_id=? and product_status='0'";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			int val=0;
			while(rs.next())
			{
				val+=rs.getInt("rowcount");
			}
		//	return (val*10);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}*/
		
		
		/*m.setUser_id(id);
		HttpSession s1=request.getSession();
		HttpSession s2=request.getSession();

		s1.setAttribute("id", id);
		
		Connection cn = MYUtil.CreateConnection();
		

		String email = null;
		String name=null;

		try {
			String sql = "select * from registration_table where user_id=?";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//email = user.getMail();
				email=rs.getString(4);
				System.out.println("In MS"+email);
				name=rs.getString(3);
				System.out.println("In MS"+name);
			}
			String mamt=request.getParameter("MembershipAmt"); 
			m.setAmount(mamt);
			s2.setAttribute("mamt", mamt);
			
			if(mamt.equalsIgnoreCase("0"))
			{
				  
				 Services.sendMailForJob(email, name); 
				
				  System.out.println("Done");
				  
			}
			else if(mamt.equalsIgnoreCase("1500")) 
			{
				response.sendRedirect("TxnTest.jsp?mamt=1500");	
			}
			else if(mamt.equalsIgnoreCase("2000")) 
			{
				response.sendRedirect("TxnTest.jsp?mamt=2000");	
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
