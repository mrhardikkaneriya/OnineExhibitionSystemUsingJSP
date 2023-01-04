package event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MYUtil.MYUtil;
import products.Product;
import registration.Registration;

public class EventDAO 
{
	public static int save(Event e)
	{
		int status=0;
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("insert into event_table(host_id,event_name,event_start,event_end,event_description,event_status) values(?,?,?,?,?,?)");
			
			ps.setInt(1, e.getH_id());
			ps.setString(2, e.getE_name());
			ps.setString(3, e.getE_start());
			System.out.println("--" + e.getE_start() + "--");
			ps.setString(4, e.getE_end());
			ps.setString(5, e.getE_desc());
			ps.setInt(6, e.getE_status());
			
			
			status=ps.executeUpdate();
			System.out.println("updated");
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
		return status;
	}
	
	
	public static int getEventIdFromEname(int hostid, String eventname)
	{
		//int eveid=0;
		try
		{
			Connection con=MYUtil.CreateConnection();
			System.out.println("con");
			PreparedStatement ps=con.prepareStatement("select * from event_table where host_id=? and event_name=?");
			ps.setInt(1,hostid);
			ps.setString(2, eventname);
			System.out.println("ps");
			ResultSet rs=ps.executeQuery();
			System.out.println("q exec");
			
			while(rs.next())
			{
				System.out.println("0");
				Event eve=new Event();
				
				System.out.println("1");
				eve.setE_id(rs.getInt("event_id"));
				
				System.out.println("2");
				//eve.setE_name(rs.getString("event_name"));
				
				//System.out.println(eve.getE_id());
				int eveid=eve.getE_id();
				
				System.out.println("3 "+eveid);
				return eveid;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return 0;
	}
	
	public static List<Event> getEventsByHid(int id)
	{
		System.out.println("In the GEBH "+id);
		List<Event> list=new ArrayList<Event>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			System.out.println("con");
			PreparedStatement ps=con.prepareStatement("select * from event_table where host_id=?");
			ps.setInt(1,id);
			System.out.println("ps");
			ResultSet rs=ps.executeQuery();
			System.out.println("q exec");
			
			while(rs.next())
			{
				Event eve=new Event();
				
				System.out.println("1");
				eve.setE_id(rs.getInt("event_id"));
				System.out.println("2");
				eve.setE_name(rs.getString("event_name"));
//				System.out.print("===" + rs.getString("event_name") + "===");
				list.add(eve);
				System.out.println("3");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	public static List<Event> getAllProductListByDate()
	{
		List<Event> list=new ArrayList<Event>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from event_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Event pro=new Event();
				
				pro.setE_id(rs.getInt("event_id"));
				pro.setH_id(rs.getInt("host_id"));
				pro.setE_name(rs.getString("event_name"));				
				pro.setE_start(rs.getString("event_start"));
				pro.setE_end(rs.getString("event_end"));
				pro.setE_desc(rs.getString("event_description"));
				pro.setE_status(rs.getInt("event_status"));
				
				list.add(pro);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static int deleteEvent(int id){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("delete from event_table where event_id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
		}catch(Exception e){System.out.println(e);}

		return status;
	}
}