package com.app.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.AnnouncementsDao;
import com.app.mystore.dao.NotificationsDao;
import com.app.mystore.dao.ResignationDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Notification;
import com.app.mystore.dto.Resignation;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;

@Service("ResignationControllerService")
public class ResignationControllerService {
	@Autowired
	public ResignationDao resignationDao;
	
	@Autowired
	public UserDao dao;
	
	@Autowired
	public NotificationService ns;

	@Autowired
	MystoreHelper helper;
	
	public int apply(Resignation applyresignation, int empid) 
	{
		int row= resignationDao.apply(applyresignation, empid);
		if (row==1)
		{ 
			
		Notification notification= new Notification();
		
		try {
			User user = dao.getUseridById(empid+"");
			notification.setUserId(dao.getManagerId());
			notification.setNotification(user.getFirstName()+" "+user.getLastName()+" has resigned");
			notification.setNotificationType("Resignation Notification");
			ns.createNotification(notification);
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		}
		return row;
	}
	
	public Resignation ResignationDetails(int empid)
	{
		Resignation resign= new Resignation();
		resign=resignationDao.ResignationDetails(empid);
		return resign;
	}
	
	public int DeleteResignation(int empid)
	{
		int result=0;
		result=resignationDao.DeleteResignation(empid) ;
		return result;
		
	}
	public List<Resignation> viewResignation()
	{
		List<Resignation> allresignations=resignationDao.GetAllResignation();	  
		return allresignations;	
	}
	
	public String acceptResignation(Resignation resign,int empid) {
		String result=resignationDao.acceptResignation(resign, empid);
		User user = null;
		try {
			user = dao.getUseridById(empid+"");
			helper.sendEmail(user.getUsername(), "Your resignation request has been approved, and your account has been inactivated.", "Resignation Accepted");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public String UpdateResignation(Resignation editresign, int empid) {
		String result =resignationDao.UpdateDetails(editresign, empid);
		return result;
	}
	
	public String rejectResignation(Resignation resign, int empid)
	{
      String result=resignationDao.rejectResignation(resign, empid);
      Notification notification=new Notification();
      try  
      {
      User user = dao.getUseridById(empid+"");
		notification.setUserId(empid);
		notification.setNotification("Your resignation was rejected, contact the manager for further details");
		notification.setNotificationType("Resignation Notification");
		ns.createNotification(notification);
      }
      catch (Exception e)
      {
    	e.getMessage();
      }
		return result;
	}

	public String inactiveEmployee(int empid) 
	{
		String result=resignationDao.inactiveEmployee(empid);
		return result;
	};
	

}
