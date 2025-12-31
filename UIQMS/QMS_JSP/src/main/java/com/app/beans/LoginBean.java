package com.app.beans;

import com.app.dao.UserDao;
import com.app.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginBean {
	
	private String email;
	private String passwd;
	private User user;
	
	public LoginBean() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void authenticate() {
		try(UserDao userDao = new UserDao()) {
			User dbUser = userDao.UserLogin(email, passwd);
			if(dbUser != null && dbUser.getPassword().equals(passwd))
				this.user = dbUser;
			else
				this.user = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
}
