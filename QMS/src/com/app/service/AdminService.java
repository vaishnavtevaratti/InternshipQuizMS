package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.menu.AdminMenu;

public class AdminService {
	
	  public static void AdminLogin(Scanner sc) {
		   System.out.println("Enter  Admin email:");
		   String email = sc.next();
		   System.out.println("enter password: ");
		   String password = sc.next();
		   try(UserDao userDao= new UserDao()) {
			   if( UserDao.Adminlogin(email, password)) {
			   System.out.println(" login sucseesful");
			   AdminMenu.adminMenu(sc);
			   }
			   else 		 
				   System.out.println("Incorrect Information");

		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }  
	
}


