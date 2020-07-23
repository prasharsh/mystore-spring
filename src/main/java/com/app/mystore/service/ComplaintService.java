package com.app.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ComplaintsDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Complaint;
import com.app.mystore.dto.Notification;
import com.app.mystore.dto.User;
import com.app.mystore.enums.NotificationTypeEnum;

@Service("complaintService")
public class ComplaintService {
	
	@Autowired
	public ComplaintsDao complaintDao;
	
	@Autowired
	public UserDao userDao;

	
	@Autowired
	public NotificationService notificationService;
	
	
	private static ComplaintService uniqueInstance;
	
	private ComplaintService() {
	}
	
	public static ComplaintService instance(){
		if(null != uniqueInstance){
			uniqueInstance = new ComplaintService();
		}
		return uniqueInstance;
	}
	
	
	public List<Complaint> getAllComplaints() throws Exception{
		return complaintDao.getAllComplaints();
		
	}
	
	public List<Complaint> getUserComplaints(int userId) throws Exception{
		return complaintDao.getUserComplaints(userId);
	}
	
	public void createComplaint(Complaint complaint) throws Exception {
		complaintDao.createComplaint(complaint);
		Notification not=new Notification();
		User user=userDao.getUseridById(String.valueOf(complaint.getUserId()));
		not.setNotification("Complaint Created  by "+user.getFirstName());
		not.setNotificationType(NotificationTypeEnum.COMPLAINT_NOTIFICATION.getType());
		System.out.println(userDao.getManagerId());
		not.setUserId(userDao.getManagerId());
		notificationService.createNotification(not);
		
	}
	
	public void updateManagerResponse(Complaint complaint) throws Exception {
		complaintDao.updateResponse(complaint);
		Notification not=new Notification();
		User user=userDao.getUseridById(String.valueOf(complaint.getUserId()));
		not.setNotification("Manager Responded To the Complaint");
		not.setNotificationType(NotificationTypeEnum.COMPLAINT_NOTIFICATION.getType());
		not.setUserId(complaint.getUserId());
		notificationService.createNotification(not);
	}
	
	public void deleteComplaint(int id) throws Exception{
		complaintDao.delteComplaint(id);
	}
	
	

}
