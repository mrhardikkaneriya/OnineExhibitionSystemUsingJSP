package products;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import event.Event;
import event.EventDAO;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512,maxFileSize = 1024 * 1024 * 512,maxRequestSize = 1024 * 1024 * 512)
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
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
	
	
	/*****GLOBAL METHOD TO EXTRACT FILE NAME**********/
	private String extractfilename(Part file) {
	    String cd = file.getHeader("content-disposition");
	    String[] items = cd.split(";");
	    for (String string : items) {
	        if (string.trim().startsWith("filename")) {
	            return string.substring(string.indexOf("=") + 2, string.length()-1);
	        }
	    }
	    return "";
	}
	/***************************************/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		System.out.println("Product Servlet start");
		
		String h_id=request.getParameter("ho_id");
		
		//String e_name=request.getParameter("eventname");
		
		String e_id=request.getParameter("eventid");
		
		String pro_name=request.getParameter("product_name");
		String pro_desc=request.getParameter("product_desc");
		String pro_price=request.getParameter("product_price");
		
		System.out.println(h_id+e_id);
		
		/*****PRODUCT IMG*****/
		String savePath = "C:\\Users\\samir\\eclipse-workspace\\Exhibition\\WebContent\\Product_Img";
		File fileSaveDir=new File(savePath);
        if(!fileSaveDir.exists())
        {
            fileSaveDir.mkdir();
        }
        Part file1 = request.getPart("img");
	 	String fileName=extractfilename(file1);
	    file1.write(savePath + File.separator + fileName);
	    String filePath= savePath + File.separator + fileName ;
		/********************************/
	  
	    try
		{
	    	int host=Integer.parseInt(h_id);
	    	int eveid=Integer.parseInt(e_id);
	    	//System.out.println("before func "+host+">>"+eveid);
	    	//int event_id=EventDAO.getEventIdFromEname(host,e_name);
	    	System.out.println("E - ID "+eveid);
			if(!(h_id.isEmpty() || e_id.isEmpty()||pro_name.isEmpty()||pro_desc.isEmpty()||pro_price.isEmpty()))
			{
				System.out.println("in if @ ID "+host);
				 Product p=new Product();
				 	p.setHost_id(host);
				 	p.setEvent_id(eveid);
				    p.setPro_name(pro_name);
				    p.setPro_desc(pro_desc);
				    p.setPro_price(Integer.parseInt(pro_price));
				    p.setPro_img(fileName);
				    
				    System.out.println("End");
				
				int value=ProductDAO.save(p);
				System.out.println("done");
				if(value>0)
				{
					response.sendRedirect("view_product.jsp");
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
