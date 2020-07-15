package com.app.mystore.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ResetPasswordDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

@Service("loginControllerService")
public class LoginControllerService {

	@Autowired
	public UserDao userDao;

	@Autowired
	public ResetPasswordDao resetPasswordDao;

	public User login(User loginUser) {		

		return userDao.loadUserByUsername(loginUser);
	}


	public String getResetToken(String email) {
		String token = "";
		User user = null;
		user = userDao.resetPasswordToken(email);
		if(user!=null) {
			Date date = new Date();
			token = date.getTime()+email;
			char tempArray[] = token.toCharArray(); 
			Arrays.sort(tempArray); 
			token = new String(tempArray);
			ResetPassword rp = new ResetPassword();
			rp.setUserid(user.getId());
			rp.setToken(token);
			int rows = resetPasswordDao.insertToken(rp);
			System.out.println(rows);
		}

		return token;
	}


}
