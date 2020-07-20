package com.app.mystore.dao;

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

	public User getUseridById(String id) throws Exception;

}
