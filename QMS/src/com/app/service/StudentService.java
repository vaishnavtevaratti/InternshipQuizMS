package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;
import com.app.dao.*;
import com.app.menu.StudentMenu;

public class StudentService {
	
	
	
	public static void StudentRegistration(Scanner sc) {
		   System.out.println("enter username: ");
		   String name = sc.next();
		   System.out.println("Enter email: ");
		   String email = sc.next();
		   System.out.println("Enter password: ");
		   String password = sc.next();
		   try(UserDao userDao= new UserDao()) {
			   if( UserDao.studentRegister(name,email, password)) {
			   System.out.println(" Registration sucseesful");
			
			   }
			   else 		
				   System.out.println(" Registration failed");

		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 }
	

	  public static void StudentLogin(Scanner sc) {
		   System.out.println("Enter student Email: ");
		   String email = sc.next();
		   System.out.println("Enter password: ");
		   String password = sc.next();
		   try(UserDao userDao= new UserDao()) {
			   if( UserDao.Studentlogin(email, password)) {
			   System.out.println(" Login sucseesful");
			   StudentMenu.studentMenu(sc);
			   }
			   else 		
				   System.out.println("Incorrect Information");

		   } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }  
	
	
}
		    	
		    	
		    
		   
