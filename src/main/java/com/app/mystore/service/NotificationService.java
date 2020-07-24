package com.app.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.NotificationsDao;
import com.app.mystore.dto.Notification;


/**
 * Author: Suraj Kandikonda
 * B00854472
 * NotificationService connects the controller to the doa class. also it provides methods to be used by other modules to
 * create notifications.
 */
@Service("notificationService")
public class NotificationService {
	
	@Autowired
	private NotificationsDao notificationDao;
	
	public List<Notification> getUserNotifications(int userId) throws Exception{
		return notificationDao.getUserNotifications(userId);
	}
	
	public void createNotification(Notification notification) throws Exception{
		notificationDao.createNotification(notification);
	}

	public void deleteNotification(int id) throws Exception{
		notificationDao.deleteNotification(id);
	}
}
