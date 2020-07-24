package com.app.mystore.service;

import com.app.mystore.dao.ApplicationDaoImpl;
import com.app.mystore.dto.Application;
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

	@Autowired
	public ApplicationDaoImpl applicationDao;

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

	User user = null;
	public User login(User loginUser) throws Exception {


		try {
			user = userDao.loadUserByUsername(loginUser);

		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
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

	public String getResetToken(String email) throws Exception {
		String token = "";
		User user = null;
		try {

			user = userDao.resetPasswordToken(email);
			userDao.InactivateAllResetPasswordTokenForUser(user.getId());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		if(user!=null) {
			token = getAlphaNumericString(8);
			ResetPassword rp = new ResetPassword();
			rp.setUserid(user.getId());
			rp.setToken(token);
			int rows = resetPasswordDao.insertToken(rp);
			System.out.println(rows);
			
			helper.sendEmail(user.getUsername(), "Please use the token: "+ token+" , to reset the password ", "Reset password token");
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


	public int register(User newUser) throws Exception {
		int row =0;
		try {
			row = userDao.registerUser(newUser);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return row;
	}


	public int updateUserProfiles(User updateForUser) {
		return userDao.updateUserProfiles(updateForUser);
	}


	public int updateUserPassword(User updatePasswordForUser) throws Exception {
		ResetPassword rp = null;
		try {
			rp =userDao.getUseridByToken(updatePasswordForUser.getToken());
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
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

	public User getUserById(String id) throws Exception {
		User user  = null;
		try {
			user = userDao.getUseridById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return user;
	}

	public int updateRole(int userID) throws Exception {
		String id = "" + userID;
		int row =0;

		try {
			user = userDao.getUseridById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		try {
			row = userDao.updateRole(user);
		}
		catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		Application application = applicationDao.getByUserID(userID);
		if(application != null){
			String body = "Hello, We would like to inform you we have accepted your application! Please sign into myStore to view the employee page.";
			helper.sendEmail(application.getEmail(), body, "Approved application");
		}


		return row;
	}

}
