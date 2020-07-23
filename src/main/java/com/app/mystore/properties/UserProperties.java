package com.app.mystore.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/user_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="user")
public class UserProperties {

	public UserProperties() {
		super();
	}

	private String getUser;
	private String updateRole;
	private String getManagerId;

	public String getUpdateRole() {
		return updateRole;
	}

	public void setUpdateRole(String updateRole) {
		this.updateRole = updateRole;
	}

	public String getGetUser() {
		return getUser;
	}

	public void setGetUser(String getUser) {
		this.getUser = getUser;
	}

	private String getUserByUsername;

	public String getGetUserByUsername() {
		return getUserByUsername;
	}

	public void setGetUserByUsername(String getUserByUsername) {
		this.getUserByUsername = getUserByUsername;
	}
	
	private String  insertResetPassword;

	public String getInsertResetPassword() {
		return insertResetPassword;
	}

	public void setInsertResetPassword(String insertResetPassword) {
		this.insertResetPassword = insertResetPassword;
	}
	
	private String registerUser;

	public String getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(String registerUser) {
		this.registerUser = registerUser;
	}
	

	private String updateUser;
	
	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	public String getDetailsByTokenId() {
		return detailsByTokenId;
	}

	public void setDetailsByTokenId(String detailsByTokenId) {
		this.detailsByTokenId = detailsByTokenId;
	}

	public String getResetPassword() {
		return resetPassword;
	}

	public void setResetPassword(String resetPassword) {
		this.resetPassword = resetPassword;
	}

	public String getInactivateToken() {
		return inactivateToken;
	}

	public void setInactivateToken(String inactivateToken) {
		this.inactivateToken = inactivateToken;
	}

	public String getGetUserById() {
		return getUserById;
	}

	public void setGetUserById(String getUserById) {
		this.getUserById = getUserById;
	}

	private String detailsByTokenId;
	
	private String resetPassword;
	
	private String inactivateToken;
	
	private String getUserById;

	public String getGetManagerId() {
		return getManagerId;
	}

	public void setGetManagerId(String getManagerId) {
		this.getManagerId = getManagerId;
	}
	
	
}
