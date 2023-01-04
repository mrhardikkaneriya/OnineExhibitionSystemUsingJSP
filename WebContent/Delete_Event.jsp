<%@page import="event.EventDAO"%>
<%@page import="products.ProductDAO"%>
<%
		int id=Integer.parseInt(request.getParameter("eid"));
		EventDAO.deleteEvent(id);
		response.sendRedirect("view_host_events.jsp?hid="+request.getParameter("hid"));
%>