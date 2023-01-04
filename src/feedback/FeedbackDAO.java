package feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MYUtil.MYUtil;
import products.Product;
import registration.Registration;

public class FeedbackDAO 
{
	public static int save(Feedback f)
	{
		int status=0;
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("insert into feedback_table(product_id, product_name, feedback_desc) values(?,?,?)");
			
			ps.setInt(1, f.getPro_id());
			ps.setString(2, f.getPro_name());
			ps.setString(3, f.getFb_desc());
			
			status=ps.executeUpdate();
			
			System.out.println("Data Saved");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static List<Feedback> getFeedbackByProID(int pid)
	{
		List<Feedback> list=new ArrayList<Feedback>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from feedback_table where product_id=?");
			ps.setInt(1, pid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Feedback fed=new Feedback();
				
				fed.setPro_name(rs.getString("product_name"));
				fed.setFb_desc(rs.getString("feedback_desc"));
				
				list.add(fed);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
}
