package registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import MYUtil.MYUtil;
import login.User;

public class RegistrationDAO 
{
	
	public static int getID(String email){
		int id=0;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from host_registration where host_mail=?");
			ps.setString(1,email);

			ResultSet result = ps.executeQuery();
			
			if (result.next()) 
			{
				id=result.getInt("host_id");
			}
			
		}catch(Exception e){System.out.println(e);}
		return id;
		
	}
	public static String getEmail(int id)
	{
		String email=null;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from host_registration where host_id=?");
			ps.setInt(1,id);

			ResultSet result = ps.executeQuery();
			
			if (result.next()) 
			{
				email=result.getString("host_mail");
			}
			
		}catch(Exception e){System.out.println(e);}
		return email;		
	}
	
	public static int update(Registration r){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			//User user = null;
		
			System.out.println("In update funct @ "+r.getHost_id());
			PreparedStatement ps=con.prepareStatement("update host_registration set host_name=?,host_mail=?,host_contact=?,host_gender=?,host_password=? where host_id=?");
			//ps.setInt(1, r.getHost_id());
			ps.setString(1, r.getName());
			ps.setString(2, r.getEmail());
			ps.setString(3, r.getContact());
			ps.setString(4, r.getGender());
			ps.setString(5, r.getPassword());
			ps.setInt(6, r.getHost_id());
			
			status=ps.executeUpdate();
			System.out.println("In update func status @ "+status);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static int updateViewer(Registration r){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			//User user = null;
		
			System.out.println("In update funct V- @ "+r.getViewer_id());
			PreparedStatement ps=con.prepareStatement("update viewer_registration set viewer_name=?,viewer_mail=?,viewer_contact=?,viewer_gender=?,viewer_password=? where viewer_id=?");
			//ps.setInt(1, r.getHost_id());
			ps.setString(1, r.getName());
			ps.setString(2, r.getEmail());
			ps.setString(3, r.getContact());
			ps.setString(4, r.getGender());
			ps.setString(5, r.getPassword());
			ps.setInt(6, r.getViewer_id());
			
			status=ps.executeUpdate();
			System.out.println("In update func status @ "+status);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static List<Registration> getAllHostRecords()
	{
		List<Registration> list=new ArrayList<Registration>();	
		try
		{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from host_registration");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Registration reg=new Registration();
				
				reg.setHost_id(rs.getInt("host_id"));
				reg.setName(rs.getString("host_name"));
				reg.setEmail(rs.getString("host_mail"));
				reg.setContact(rs.getString("host_contact"));
				reg.setGender(rs.getString("host_gender"));
				reg.setStatus(rs.getInt("host_status"));
				
				list.add(reg);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	public static List<Registration> getRecordByHostId(int id){
		List<Registration> list=new ArrayList<Registration>();
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from host_registration where host_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Registration pjr=new Registration();
				pjr=new Registration();
				pjr.setHost_id(rs.getInt("host_id"));
				pjr.setName(rs.getString("host_name"));
				pjr.setEmail(rs.getString("host_mail"));
				pjr.setContact(rs.getString("host_contact"));
				pjr.setGender(rs.getString("host_gender"));
				pjr.setPassword(rs.getString("host_password"));
				
				list.add(pjr);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Registration> getRecordByViewerId(int id){
		List<Registration> list=new ArrayList<Registration>();
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from viewer_registration where viewer_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Registration pjr=new Registration();
				pjr=new Registration();
				
				pjr.setViewer_id(rs.getInt("viewer_id"));
				pjr.setName(rs.getString("viewer_name"));
				pjr.setEmail(rs.getString("viewer_mail"));
				pjr.setContact(rs.getString("viewer_contact"));
				pjr.setGender(rs.getString("viewer_gender"));
				pjr.setPassword(rs.getString("viewer_password"));
				
				list.add(pjr);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static List<Registration> getRecordByAdminId(int id){
		List<Registration> list=new ArrayList<Registration>();
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("select * from admin_table where admin_id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Registration pjr=new Registration();
				pjr=new Registration();
				
				pjr.setAdmin_id(rs.getInt("admin_id"));
				pjr.setName(rs.getString("admin_name"));
				pjr.setEmail(rs.getString("admin_mail"));
				pjr.setContact(rs.getString("admin_contact"));
//				pjr.setGender(rs.getString("viewer_gender"));
//				pjr.setPassword(rs.getString("viewer_password"));
				
				list.add(pjr);
			}
		}catch(Exception e){System.out.println(e);}
		return list;
	}
	
	public static int updateHostStatus(int h_id, int h_st){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			//User user = null;
		
//			System.out.println("In update funct V- @ "+r.getViewer_id());
			PreparedStatement ps=con.prepareStatement("update host_registration set host_status=? where host_id=?");
			
			ps.setInt(1, h_st);
			ps.setInt(2, h_id);
			
			status=ps.executeUpdate();
			System.out.println("In update func status @ "+status);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
//		return status;
		return status;
	}
	
	public static int rejectHostStatus(int h_id){
		int status=0;
		try{
			Connection con=MYUtil.CreateConnection();
			PreparedStatement ps=con.prepareStatement("DELETE FROM host_registration WHERE host_id=?");
			
			ps.setInt(1, h_id);
			
			status=ps.executeUpdate();
			System.out.println("In update func status @ "+status);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
}


