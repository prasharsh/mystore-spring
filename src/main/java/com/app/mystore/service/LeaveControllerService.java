/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 * LeaveControllerService is the service that handles
 * all the busniess logic for the leave module.
 * interacts with dao for CRUD operations
 */


package com.app.mystore.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.mystore.dao.LeaveDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Leave;
import com.app.mystore.dto.Notification;
import com.app.mystore.dto.User;

@Service("leaveControllerService")
public class LeaveControllerService {
	
	@Autowired
	public LeaveDao leaveDao;
	
	@Autowired
	public NotificationService ns;
	
	@Autowired
	public UserDao dao;

	public String applyLeave(Leave leaveDetails, int empid) {
		// TODO Auto-generated method stub
		String result = leaveDao.enterLeaveData(leaveDetails, empid);
		// on successfully applying leave providing notification to the manager
		if (result== "Success")
		{ 
		Notification notification= new Notification();
		
		try {
			User user = dao.getUseridById(empid+"");
			notification.setUserId(dao.getManagerId());
			notification.setNotification(user.getFirstName()+" "+user.getLastName()+" has applied for leave.");
			notification.setNotificationType("Leave Notification");
			ns.createNotification(notification);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		return result;
	}

	public List<Leave> viewLeaveRequest() {
		// TODO Auto-generated method stub
		List<Leave> pendingRequest = leaveDao.pendingLeave();
		return pendingRequest;
	}

	public List<Leave> viewLeaveHistory(int empid) {
		// TODO Auto-generated method stub
		List<Leave> leaveHistory = leaveDao.leaveHistory(empid);
		return leaveHistory;
	}

	public String acceptLeave(Leave leave, int empid) {
		String result=leaveDao.acceptLeave(leave, empid);
		// on successfully acceptance of leave providing notification to the manager
		if (result== "Success")
		{ 
		Notification notification= new Notification();
		
		try {
			User user = dao.getUseridById(empid+"");
			notification.setUserId(empid);
			notification.setNotification("Leave accepted");
			notification.setNotificationType("Leave Notification");
			ns.createNotification(notification);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		return result;
	}

	public String rejectLeave(Leave leave, int empid) {
		String result=leaveDao.rejectLeave(leave, empid);
		// on successfully rejection of leave providing notification to the manager
		if (result== "Success")
		{ 
		Notification notification= new Notification();
		
		try {
			User user = dao.getUseridById(empid+"");
			notification.setUserId(empid);
			notification.setNotification("Leave rejected");
			notification.setNotificationType("Leave Notification");
			ns.createNotification(notification);	
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		return result;
	}

	public String DeleteResignation(int id) {
		String result=leaveDao.deleteLeave(id);
		return result;
	}
	
	
	
	

}
