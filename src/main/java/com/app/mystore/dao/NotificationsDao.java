package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Notification;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * NotificationsDao is an interface for all the DB operations required
 * for the  Notifications
 */
public interface NotificationsDao {

	public List<Notification> getUserNotifications(int userId) throws Exception;
	public void createNotification(Notification notification) throws Exception;
	public void deleteNotification(int id) throws Exception;
	
}
