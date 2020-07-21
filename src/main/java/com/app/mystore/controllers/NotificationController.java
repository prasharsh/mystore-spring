package com.app.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Notification;
import com.app.mystore.service.NotificationService;

@CrossOrigin
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/getUserNotifications/{userId}")
	public List<Notification> getAllAnnouncements(@PathVariable int userId){
		try {
			return notificationService.getUserNotifications(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path ="/createNotification")
	public String createNotification(@RequestBody Notification not) {
		try {
			notificationService.createNotification(not);
			return "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
		
	}
	@PutMapping("/deleteNotification/{notificationId}")
	public String deleteNotification(@PathVariable int notificationId) {
		try {
			notificationService.deleteNotification(notificationId);
			return "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}
}
