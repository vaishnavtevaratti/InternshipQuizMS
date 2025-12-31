package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.model.*;
import com.app.util.Dbutil;

public class UserDao implements AutoCloseable {
	
	private static Connection connection = null;
	public static User curUser=null;
	public UserDao() throws SQLException {
		connection = Dbutil.getConnection();
	}
	
	
	public static User UserLogin(String email , String password) throws SQLException {
		 String sql= "select * from users where email =? AND password_hash =? ";
		 
		 User user = new User();
		  try (  PreparedStatement ps = connection.prepareStatement(sql);){
			 ps.setString(1,email);
			  ps.setString(2, password);
			  ResultSet rs = ps.executeQuery();
			  
			if(rs.next()) {
				
				
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setRole(rs.getString(5));
				return user ;
			}
			  
//			  connection.close();
//			  ps.close();
//			
		  }catch (SQLException e) {
			  e.printStackTrace();
			// TODO: handle exception
		}
		  return null ;
		  
		 
	 }
	
	

	 public static boolean studentRegister(String name , String email , String password )throws SQLException {
		 String sql = " insert into users(name,email,password_hash,role) values(?,?,?,?)";
		 try(	  PreparedStatement ps = connection.prepareStatement(sql)){
			
		
			  ps.setString(1, name);
			  ps.setString(2, email );
			  ps.setString(3, password );
			  ps.setString(4, "student" );

			  ps.executeUpdate();
//			  connection.close();
//			  ps.close();
			  
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return false;
	 }

	

	
	
	
	
	
	@Override
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
}
