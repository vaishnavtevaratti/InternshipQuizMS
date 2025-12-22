package com.app.service;

import java.io.File;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.model.Quiz;
import com.app.model.User;

public class AdminService {
	
	
	public static void AdminLogin(Scanner sc) {
		User admin =new User ();
	
		System.out.println("Enter the email:");
		admin.setEmail(sc.next());
		System.out.println("Enter password:");
		admin.setPassword(sc.next());
		admin.setRole("Admin");

        try {
            boolean success = UserDao.AdminLogin(admin);
            if (success) {
                System.out.println("Admin logged in successfully");
            } else {
                System.out.println("Invalid info");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	  public static void createQuiz(Scanner sc, int adminId) throws Exception {
	        sc.nextLine(); // clear buffer

	        System.out.println("Enter quiz title:");
	        String title = sc.nextLine();

	        System.out.println("Enter question file path:");
	        File file = new File(sc.nextLine());

	        if (!file.exists()) {
	            throw new Exception("File not found");
	        }

	        Quiz quiz = new Quiz();
	        quiz.setTitle(title);
	        quiz.setCreatorID(adminId);

	        System.out.println("Quiz created successfully");
	    }
	}



