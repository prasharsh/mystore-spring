package com.app.mystore.dao;

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public interface UserDao {

	public User loadUserByUsername(User loginUser);

	public User resetPasswordToken(String email);

	public int registerUser(User newUser);

	public int updateUserProfiles(User updateForUser);

	public ResetPassword getUseridByToken(String token);

	public int updateUserPassword(User updatePasswordForUser);

	public void InactivateResetPasswordToken(int id);

}
