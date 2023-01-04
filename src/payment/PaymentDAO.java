package payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MYUtil.MYUtil;
import login.User;
import products.Product;
import registration.Registration;

public class PaymentDAO 
{
	public static int CountProducts(int id)
	{
		int val=0;
		Connection cn = MYUtil.CreateConnection();
		
		try 
		{
			String sql = "select * from product_table where event_id=? and product_status=0";
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				val++;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return (val*10);
	}
	
	public static int save(String id, int amount)
	{
		int status=0;
		
		try
		{
			User uo = new User();
			
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("insert into payment_table(user_id, user_type, transaction_id,amount_value) values(?,?,?,?)");
			
			
			int uid=0;
			if(uo.getUser_type() == "HOST") {
				uid=uo.getHost_id();
			}
			else if(uo.getUser_type() == "VIEWER") {
				uid=uo.getViewer_id();
			}
			ps.setInt(1, uid);
			ps.setString(2, uo.getUser_type());
			ps.setString(3, id);
			ps.setInt(4, amount);
			
			status=ps.executeUpdate();
			System.out.println("updated");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		return status;
	}
	
	public static int UpdateProductPaymentById(int id)
	{
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
		
			PreparedStatement ps=con.prepareStatement("update product_table set product_status=? where event_id=?");
			
			ps.setInt(1, 1);
			ps.setInt(2, id);
			
			status=ps.executeUpdate();
			System.out.println("In update func status @ "+status); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static List<Payment> getAllPaymentRecords()
	{
		List<Payment> list=new ArrayList<Payment>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from payment_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Payment reg=new Payment();
				
				reg.setUser_id(rs.getInt("user_id"));
				reg.setU_type(rs.getString("user_type"));
				reg.setTrans_id(rs.getString("transaction_id"));
				reg.setPay_amt(Integer.parseInt(rs.getString("amount_value")));
				
				list.add(reg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
}
