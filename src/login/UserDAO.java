package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import MYUtil.MYUtil;



public class UserDAO 
{
	public User checkLogin(String email, String password) throws SQLException,ClassNotFoundException 
	{	
		Connection con=MYUtil.CreateConnection();
		
		/*TRIAL*/
		/*PreparedStatement statement = null;
		System.out.println("At DAO>>> "+email+" >> "+password);
		User user = null;
		ResultSet result;
		if((statement=con.prepareStatement("SELECT * FROM host_registration WHERE host_mail = ? AND host_password = ?")) != null)
		
		{
			System.out.println("H.L.");
			statement.setString(1, email);
			statement.setString(2, password);
			
			System.out.println("1");
			result = statement.executeQuery();
			
			System.out.println("2");
			if(result!=null)
			{
				//Host verification check
				if (result.next()) 
				{
					System.out.println("3");
					user = new User();
					user.setHost_id(result.getInt("host_id"));
					user.setHost_mail(email);
					user.setHost_password(password);
					user.setHost_name(result.getString("host_name"));
					user.setUser_type("HOST");
					System.out.println("4");
				}
			}
			System.out.println("H.L.D.");
		}
		else if((statement=con.prepareStatement("SELECT * FROM viewer_registration WHERE viewer_mail = ? AND viewer_password = ?"))!=null)
		{
			System.out.println("V.L.");
			statement.setString(1, email);
			statement.setString(2, password);
			
			result = statement.executeQuery();
			
			if(result!=null)
			{
				if (result.next()) 
				{
					user = new User();
					user.setViewer_id(result.getInt("viewer_id"));
					user.setViewer_mail(email);
					user.setViewer_password(password);		
					user.setViewer_name(result.getString("viewer_name"));
					user.setUser_type("VIEWER");
				}
			}
			System.out.println("V.L.D.");
		}
		else if((statement=con.prepareStatement("SELECT * FROM admin_table WHERE admin_mail = ? AND admin_password = ?"))!=null)
		{
			System.out.println("A.L.");
			statement.setString(1, email);
			statement.setString(2, password);
			
			result = statement.executeQuery();
			
			if(result!=null)
			{
				if (result.next()) 
				{
					user = new User();
					user.setAdmin_id(result.getInt("admin_id"));
					user.setAdmin_name(result.getString("admin_name"));
					user.setAdmin_mail(email);
					user.setAdmin_password(password);
					user.setAdmin_contact(result.getString("admin_contact"));
					user.setUser_type("ADMIN");
					
				}
			}
			System.out.println("A.L.D.");
		}
		else
		{
			user.setUser_type("UNKNOWN");
		}*/
		/*TRIAL END*/
		
		
		String sql = "SELECT * FROM host_registration WHERE host_mail = ? AND host_password = ?;";
		PreparedStatement statement = con.prepareStatement(sql);

		statement.setString(1, email);
		statement.setString(2, password);
		
		User user = null;
		ResultSet result = statement.executeQuery();
		
		if(result!=null)
		{
			//Host verification check
			if (result.next()) 
			{
				user = new User();
				user.setHost_id(result.getInt("host_id"));
				user.setHost_mail(email);
				user.setHost_password(password);
				user.setHost_name(result.getString("host_name"));
				user.setUser_type("HOST");
			}
		}
		
		///VIEWER
		sql = "SELECT * FROM viewer_registration WHERE viewer_mail = ? AND viewer_password = ?;";
		PreparedStatement statement_v = con.prepareStatement(sql);

		statement_v.setString(1, email);
		statement_v.setString(2, password);
		
		result = statement_v.executeQuery();
		
		if(result!=null)
		{
			if (result.next()) 
			{
				user = new User();
				user.setViewer_id(result.getInt("viewer_id"));
				user.setViewer_mail(email);
				user.setViewer_password(password);		
				user.setViewer_name(result.getString("viewer_name"));
				user.setUser_type("VIEWER");
			}
		}
		
		
		///ADMIN
				sql = "SELECT * FROM admin_table WHERE admin_mail = ? AND admin_password = ?;";
				PreparedStatement statement_a = con.prepareStatement(sql);

				statement_a.setString(1, email);
				statement_a.setString(2, password);
				
				result = statement_a.executeQuery();
				
				if(result!=null)
				{
					if (result.next()) 
					{
						user = new User();
						user.setAdmin_id(result.getInt("admin_id"));
						user.setAdmin_name(result.getString("admin_name"));
						user.setAdmin_mail(email);
						user.setAdmin_password(password);
						user.setAdmin_contact(result.getString("admin_contact"));
						user.setUser_type("ADMIN");	
					}
				}

		con.close();
		return user;
	}
}
