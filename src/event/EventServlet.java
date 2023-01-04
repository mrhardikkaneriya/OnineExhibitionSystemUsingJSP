package event;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventServlet() {
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
		
		String id=request.getParameter("hid");
		String name=request.getParameter("eventname");
		String start=request.getParameter("eventstart");
		String end=request.getParameter("eventend");
		String desc=request.getParameter("eventdes");
		
		System.out.println(id+">>"+name+">>"+start+">>"+end+">>"+desc);
		try
		{
			int host=Integer.parseInt(id);
			if(!(id.isEmpty() || name.isEmpty()||start.isEmpty()||end.isEmpty()||desc.isEmpty()))
			{
				System.out.println("in if @ ID "+Integer.parseInt(id));
				Event e=new Event();

				e.setH_id(host);
				e.setE_name(name);
				e.setE_start(start);
				e.setE_end(end);
				e.setE_desc(desc);
				
				int value=EventDAO.save(e);
				System.out.println("done");
				if(value>0)
				{
					response.sendRedirect("Success.jsp");
				}
			}
			else
			{
				String message = "Invalid email/password";
				System.out.println(message);
			}
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
}