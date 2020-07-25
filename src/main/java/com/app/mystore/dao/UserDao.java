package com.app.mystore.dao;


/**
 * Author: Prashant kumar
 * B00847456
 * UserDao is the interface that works with the impl 
 * to interact with the data base layer for crud operations
 */

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public interface UserDao {

	public User loadUserByUsername(User loginUser) throws Exception;

	public User resetPasswordToken(String email) throws Exception;

	public int registerUser(User newUser) throws Exception;

	public int updateUserProfiles(User updateForUser);

	public ResetPassword getUseridByToken(String token) throws Exception;

	public int updateUserPassword(User updatePasswordForUser);

	public void InactivateResetPasswordToken(int id);

	public void InactivateAllResetPasswordTokenForUser(int userId);
	
	public User getUseridById(String id) throws Exception;

	public int updateRole(User user);

	int getManagerId() throws Exception;


}
