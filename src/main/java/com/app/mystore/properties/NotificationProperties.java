package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * NotificationProperties is used to get the SQL queries stored in the notifications_sql.properties file.
 */
@Configuration
@PropertySource("classpath:sql/notifications_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="notification")
public class NotificationProperties {

	private String getUserNotifications;
	private String createNotification;
	private String deleteNotification;
	public String getGetUserNotifications() {
		return getUserNotifications;
	}
	public void setGetUserNotifications(String getUserNotifications) {
		this.getUserNotifications = getUserNotifications;
	}
	public String getCreateNotification() {
		return createNotification;
	}
	public void setCreateNotification(String createNotification) {
		this.createNotification = createNotification;
	}
	public String getDeleteNotification() {
		return deleteNotification;
	}
	public void setDeleteNotification(String deleteNotification) {
		this.deleteNotification = deleteNotification;
	}
	
	
}
