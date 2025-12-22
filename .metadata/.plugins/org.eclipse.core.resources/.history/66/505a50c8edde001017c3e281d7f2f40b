package com.app.menu;

import java.util.Scanner;
import com.app.service.*;

public class MainMenu {
	private static AdminService adminService = new AdminService();
	private static StudentService studentService = new StudentService();
	
	public static  int mainMenuOptions(Scanner sc) {
		System.out.println("**************Main menu*******************");
		System.out.println("0.Exit");
		System.out.println("1.Admin Login  ");
		System.out.println("2.Student Register");
		System.out.println("3.Student Login");
		System.out.println(" Enter your choice: ");

		return sc.nextInt();
	}
	
	public static void mainMenu(Scanner sc) {
		
		int choice ;
		while ((choice = mainMenuOptions(sc)) != 0) {
			switch (choice) {
			case 1:
				System.out.println("You have selected Admin Login");
				System.out.println();
				adminService.AdminLogin(sc);				
				break;
			case 2:
				System.out.println("You have selected Student Register");
				System.out.println();
				studentService.StudentRegistration(sc);
				break;
			case 3:
				System.out.println("You have selected Student Login ");
				System.out.println();
				studentService.StudentLogin(sc);
			
				break;

			default:
				System.out.println("Wrong choice...");
				break;
			}
		}
		System.out.println("Thankyou for using our App!");
	}
	

}