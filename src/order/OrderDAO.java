package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Enumeration;

import javax.mail.Session;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import MYUtil.MYUtil;
import login.User;

import java.lang.Object;

public class OrderDAO {
	
	public static int save(String t_id)
	{
		int status=0;
		
		try
		{
			User uo = new User();
			
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("insert into order_table(user_id, user_type, product_id, transaction_id, order_address) values(?,?,?,?,?)");
			
			
			int uid=0;
			if(uo.getUser_type() == "HOST") {
				uid=uo.getHost_id();
			}
			else if(uo.getUser_type() == "VIEWER") {
				uid=uo.getViewer_id();
			}
			Order or = new Order();
			ps.setInt(1, uid);
			ps.setString(2, uo.getUser_type());
			ps.setInt(3, or.getPro_id());
			ps.setString(4, t_id);
			ps.setString(5, or.getOrd_add());
	
			
			status=ps.executeUpdate();
			System.out.println("updated");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		return status;
	}

}
