package products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MYUtil.MYUtil;
import event.Event;
import registration.Registration;

public class ProductDAO 
{
	public static int save(Product p)
	{
		int status=0;
		
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("insert into product_table(event_id,host_id,product_name,product_desc, product_price, product_image) values(?,?,?,?,?,?)");
			
			
			ps.setInt(1, p.getEvent_id());
			ps.setInt(2, p.getHost_id());
			ps.setString(3, p.getPro_name());
			ps.setString(4, p.getPro_desc());
			ps.setInt(5, p.getPro_price());
			ps.setString(6, p.getPro_img());
					
			status=ps.executeUpdate();
			System.out.println("updated");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static int update(int pid){
		
		System.out.println("PID FROM SERVLET "+pid);
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps;
			Product pro=new Product();
			if(pro.getPro_img() != null) {
			ps=con.prepareStatement("update product_table set event_id=?,host_id=?,product_name=?,product_desc=?,product_price=?,product_image=? where product_id=?");
			
			
			System.out.println("1+");
			//ps.setInt(1,pid);
			ps.setInt(1, pro.getEvent_id());
			ps.setInt(2, pro.getHost_id());
			ps.setString(3, pro.getPro_name());
			System.out.println("2");
			ps.setString(4, pro.getPro_desc());
			System.out.println("3");
			ps.setInt(5, pro.getPro_price());
			System.out.println("4");
			ps.setString(6, pro.getPro_img());
			System.out.println("5");
			ps.setInt(7, pid);
			}
			else
			{
				ps=con.prepareStatement("update product_table set event_id=?,host_id=?,product_name=?,product_desc=?,product_price=? where product_id=?");
				
				
				System.out.println(pro.getPro_img());
				//ps.setInt(1,pid);
				ps.setInt(1, pro.getEvent_id());
				ps.setInt(2, pro.getHost_id());
				ps.setString(3, pro.getPro_name());
				System.out.println("2");
				ps.setString(4, pro.getPro_desc());
				System.out.println("3");
				ps.setInt(5, pro.getPro_price());
				System.out.println("5");
				ps.setInt(6, pro.getPro_id());
			}
			
			status=ps.executeUpdate();
			System.out.println("UPDATED"+status);
			
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	
	public static int delete(int id){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("delete from product_table where product_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}

	
	public static List<Product> getAllProductList()
	{
		List<Product> list=new ArrayList<Product>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from product_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Product pro=new Product();
				
				pro.setPro_id(rs.getInt("product_id"));
				pro.setEvent_id(rs.getInt("event_id"));
				pro.setHost_id(rs.getInt("host_id"));
				pro.setPro_name(rs.getString("product_name"));
				pro.setPro_desc(rs.getString("product_desc"));
				pro.setPro_price(rs.getInt("product_price"));
				pro.setPro_img(rs.getString("product_image"));
				
				list.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	
	public static String getImg(int prodid)
	{
		String pp=null;
		try {
			System.out.println("1");
			Connection cn=MYUtil.CreateConnection();
			String sql="select * from product_table where product_id=?";
			PreparedStatement pst=cn.prepareStatement(sql);
			System.out.println("2");
			
			pst.setInt(1, prodid);
			System.out.println("3");
			ResultSet rs=pst.executeQuery();
			System.out.println("4");
			if(rs.next())
			{
				System.out.println("5");
				pp=rs.getString("product_image");
				System.out.println("6");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pp;
	}
	
	
	public static Product getRecordByIdTo(int id){
		Product pro=null;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from product_table where product_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				pro=new Product();
				pro.setPro_id(rs.getInt("product_id"));
				pro.setEvent_id(rs.getInt("event_id"));
				pro.setHost_id(rs.getInt("host_id"));
				pro.setPro_name(rs.getString("product_name"));
				pro.setPro_desc(rs.getString("product_desc"));
				pro.setPro_price(rs.getInt("product_price"));
				pro.setPro_img(rs.getString("product_image"));
			}	
			
		}catch(Exception e){System.out.println(e);}
		return pro;
	}
	
	public static List<Product> getRecordByEventId(int hid, int eid){
		Product pro=null;
		List<Product> list=new ArrayList<Product>();
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from product_table where host_id=? and event_id=?");
			ps.setInt(1,hid);
			ps.setInt(2,eid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				pro=new Product();
				pro.setPro_id(rs.getInt("product_id"));
				pro.setEvent_id(rs.getInt("event_id"));
				pro.setHost_id(rs.getInt("host_id"));
				pro.setPro_name(rs.getString("product_name"));
				pro.setPro_desc(rs.getString("product_desc"));
				pro.setPro_price(rs.getInt("product_price"));
				pro.setPro_img(rs.getString("product_image"));
				
				list.add(pro);
			}	
			
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Product> getProductByEventId(int eid){
		Product pro=null;
		List<Product> list=new ArrayList<Product>();
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from product_table where event_id=?");
			ps.setInt(1,eid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{	
				pro=new Product();
				pro.setPro_id(rs.getInt("product_id"));
				pro.setEvent_id(rs.getInt("event_id"));
				pro.setHost_id(rs.getInt("host_id"));
				pro.setPro_name(rs.getString("product_name"));
				pro.setPro_desc(rs.getString("product_desc"));
				pro.setPro_price(rs.getInt("product_price"));
				pro.setPro_img(rs.getString("product_image"));
				
				list.add(pro);
			}	
			
		}catch(Exception e){System.out.println(e);}
		return list;
	}
}
