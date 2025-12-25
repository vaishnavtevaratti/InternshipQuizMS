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
	
	
	public static boolean Adminlogin(String email , String password) throws SQLException {
		 String sql= "select * from users where email =? AND password_hash =? AND role ='Admin'  ";
		  try (  PreparedStatement ps = connection.prepareStatement(sql);){
			 ps.setString(1,email);
			  ps.setString(2, password);
			  ResultSet rs = ps.executeQuery();
			  
			if(rs.next()) {
				
				curUser=new User();
				curUser.setId(rs.getInt(1));
				curUser.setName(rs.getString(2));
				curUser.setEmail(rs.getString(3));
				curUser.setPassword(rs.getString(4));
				curUser.setRole(rs.getString(5));
				return true;
			}
			  
//			  connection.close();
//			  ps.close();
//			
		  }catch (SQLException e) {
			  e.printStackTrace();
			// TODO: handle exception
		}
		  return false ;
		  
		 
	 }
	
	

	 public static boolean studentRegister(String name , String email , String password )throws SQLException {
		 String sql = " insert into users(name,email,password_hash,role) values(?,?,?,?)";
		 try(	  PreparedStatement ps = connection.prepareStatement(sql);){
			
		
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
	 
	 public static boolean Studentlogin(String email , String password)throws SQLException {
		 String sql="select * from users where email =? AND password_hash =? AND role ='Student'   ";
		  try (PreparedStatement ps = connection.prepareStatement(sql)){

			
			  ps.setString(1,email);
			  ps.setString(2, password);
			  ResultSet rs = ps.executeQuery();
			  
			  if(rs.next()) {
					curUser=new User();
					curUser.setId(rs.getInt(1));
					curUser.setName(rs.getString(2));
					curUser.setEmail(rs.getString(3));
					curUser.setPassword(rs.getString(4));
					curUser.setRole(rs.getString(5));
					return true;
				}
//			  connection.close();
//			  ps.close();
//		
		  }catch (SQLException e) {
			  e.printStackTrace();
			// TODO: handle exception
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
