<%@page import="products.ProductDAO"%>
<%
		int id=Integer.parseInt(request.getParameter("id"));
		ProductDAO.delete(id);
		response.sendRedirect("view_product_list.jsp");
%>