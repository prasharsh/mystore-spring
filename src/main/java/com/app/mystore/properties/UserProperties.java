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
}
