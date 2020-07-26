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

/**
 * Author: Lavanya Nili
 * B00834718
 * ResignationControllerService  is the service to handle
 * all the business logic for the resignation module handled by the manager and the employee
 * This service interacts with the DAO for CRUD operations
 */


@Service("ResignationControllerService")
public class ResignationControllerService {
	@Autowired
	public ResignationDao resignationDao;
	
	/**
	 * Author:Prashant kumar
	 * B00847456
	 * Any methods of UserDao and the MystoreHelper is implemented by the above author. 
	 */

	@Autowired
	public UserDao dao;
	
	@Autowired
	MystoreHelper helper;
	@Autowired
	

	/**
	  *Author: Suraj Kandikonda
     * B00854472
	 * Services of NotificationService is implemented by the above author.
	 */
	public NotificationService ns;
	
	
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * apply  is the service to handle applying the resignation
	 * It checks if user has previously applied or not and then lets the user apply.
	 * return result and integer (0 or 1) to the apply method of the ResignationController
	 */

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
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * ResignationDetails  is the service to view the resignation details 
	 * It fetches the resignation details applied by the user only where the status of the resignation is not accepted/rejected
	 * return result as resignation object
	 */
	
	public Resignation ResignationDetails(int empid)
	{
		Resignation resign= new Resignation();
		resign=resignationDao.ResignationDetails(empid);
		return resign;
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * DeleteResignation  is the service to delete the resignation that is applied
	 * return result as an integer (0 or 1)
	 */
	
	public int DeleteResignation(int empid)
	{
		int result=0;
		result=resignationDao.DeleteResignation(empid) ;
		return result;
		
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * viewResignations is the service to view all the resignations applied
	 * It returns a list of objects of type resignation 
	 */
	
	public List<Resignation> viewResignation()
	{
		List<Resignation> allresignations=resignationDao.GetAllResignation();	  
		return allresignations;	
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * acceptResignation is the service to handles the action accept 
	 * It changes the request status applied by the user from 'pending' to 'accepted'
	 * It returns a String 
	 */
	
	public String acceptResignation(Resignation resign,int empid) {
		String result = null;
		try {
			User user = null;
			user = dao.getUseridById(empid+"");
			 result=resignationDao.acceptResignation(resign, empid);
			helper.sendEmail(user.getUsername(), "Your resignation request has been approved, and your account has been inactivated.", "Resignation Accepted");
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * UpdateResignation  is the service to update the resignation details
	 * It fetches the resignation id, captures the reason and updates the resignation against the same resignation id
	 * returns string
	 */
	
	public String UpdateResignation(Resignation editresign, int empid) {
		String result =resignationDao.UpdateDetails(editresign, empid);
		return result;
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * rejectResignation is the service to handles the action reject 
	 * It changes the request status applied by the user from 'pending' to 'rejected'
	 * It returns a string
	 */
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

	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * inactiveEmployee is the method to handle the user profile after accepting the resignation
	 * It deactivates the user and sends an email notification to the user informing the same
	 * It returns a string 
	 */
	public String inactiveEmployee(int empid) 
	{
		String result=resignationDao.inactiveEmployee(empid);
		return result;
	};
	

}
