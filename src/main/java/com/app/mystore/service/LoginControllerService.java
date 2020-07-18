package com.app.mystore.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ResetPasswordDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;

@Service("loginControllerService")
public class LoginControllerService {

	@Autowired
	public UserDao userDao;

	private static LoginControllerService uniqueInstance;

	private LoginControllerService(){}

	public static LoginControllerService instance(){
		if(null != uniqueInstance){
			uniqueInstance = new LoginControllerService();
		}
		return uniqueInstance;
	}

	@Autowired
	public ResetPasswordDao resetPasswordDao;
	@Autowired
	public MystoreHelper helper;
	private User user = null;

	public User login(User loginUser) {		
		user = userDao.loadUserByUsername(loginUser);
		return user;
	}

	public User getauthenciatedUser() throws Exception {
		if(null != user ){
			return user;
		}
		else {
			throw new Exception("User requires Authenciation");
		}
	}

	public String getResetToken(String email) {
		String token = "";
		User user = null;
		user = userDao.resetPasswordToken(email);
		if(user!=null) {
			token = getAlphaNumericString(8);
			ResetPassword rp = new ResetPassword();
			rp.setUserid(user.getId());
			rp.setToken(token);
			int rows = resetPasswordDao.insertToken(rp);
			System.out.println(rows);
			helper.sendEmail(user.getUsername(), token);
		}

		return token;
	}

	 static String getAlphaNumericString(int n) 
	    { 
	  
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    }


	public int register(User newUser) {
		
		return userDao.registerUser(newUser);
	}


	public int updateUserProfiles(User updateForUser) {
		return userDao.updateUserProfiles(updateForUser);
	}


	public int updateUserPassword(User updatePasswordForUser) {
		ResetPassword rp =userDao.getUseridByToken(updatePasswordForUser.getToken());
		if(rp!=null) {
			updatePasswordForUser.setId(rp.getUserid());
			int rows = userDao.updateUserPassword(updatePasswordForUser);
			if(rows>0) {
				userDao.InactivateResetPasswordToken(rp.getId());
				return rows;
			}
			else 
				return 0;
		}
		return 0;
	} 
	
}
