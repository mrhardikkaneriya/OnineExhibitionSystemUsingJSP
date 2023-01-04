package feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import products.ProductDAO;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String pr_id=request.getParameter("prod_id");
		String pr_nm=request.getParameter("prod_name");
		String fb_desc=request.getParameter("prod_fb");
		
		String eventid=request.getParameter("event_id");
		System.out.print("NAME?"+pr_nm);
		Feedback fb=new Feedback();
		int pid=Integer.parseInt(pr_id);
	
		fb.setPro_id(pid);
		fb.setPro_name(pr_nm);
		fb.setFb_desc(fb_desc);
		
		int value=FeedbackDAO.save(fb);
		System.out.println("done");
		if(value>0)
		{
			response.sendRedirect("view_event_product.jsp?id="+eventid);
		}
	}

}
