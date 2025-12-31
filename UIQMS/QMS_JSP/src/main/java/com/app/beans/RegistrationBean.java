package com.app.beans;

import com.app.dao.UserDao;
import com.app.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RegistrationBean {
	
	private String name ;
	private String email ;
	private String password ;
	boolean regStatus ;
	public RegistrationBean() {
		
	}
	
	public boolean registerUser() {
		try(UserDao userDao = new UserDao()) {
		regStatus=	userDao.studentRegister(name,email, password);
		return regStatus;
		} catch (Exception e) {
			e.printStackTrace();
			regStatus = false;
			return regStatus;
		}	
	}
	

}
