package com.app.mystore.service;

import com.app.mystore.dao.ApplicationDao;
import com.app.mystore.dao.ApplicationDaoImpl;
import com.app.mystore.dao.InterviewDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Application;
import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import com.app.mystore.dto.Notification;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Author: Mitchell Moore
 * B00647455
 * InterviewService connects the controller to the doa class. It also generates and sends emails to users.
 */
@Service("InterviewService")
public class InterviewService {
    @Autowired
    public InterviewDao dao;

    @Autowired
    public ApplicationDaoImpl applicationDao;
    
    @Autowired
	public UserDao userdao;
    
    @Autowired
    public NotificationService ns;

    @Autowired
    public MystoreHelper helper;

    public Interview fetchByInterviewID(int interviewID) {
        Interview interview = dao.getByInterviewID(interviewID);
        return interview;
    }

    /**
     * addInterview sends an email to the applicant with the interview details.
     * @param interview
     * @return Boolean true => operations successful, false => operations failed.
     */
    public Boolean addInterview(Interview interview) {
    	try 
    	{
        Application application = applicationDao.getByApplicationID(interview.getApplicationID());
        if (application != null) {
            int result = dao.insertInterview(interview);
            if (result > 0) {
                if (interview.getNotify().equals("true")) {
                	//notification to the guest 
                	Notification notification= new Notification(); 
            			notification.setUserId(application.getUserID());
       			        notification.setNotification("You have an interview scheduled for "+ interview.getDate() +" check your email id for interview details"  );
            			notification.setNotificationType("Interview Notification");
            			ns.createNotification(notification);
            			
            		
                    String body = "Hello,\n\n Thank you for your interest for working at myStore. We would like to set up an interview via: " + interview.getType() + " , on " + interview.getDate() + " , at " + interview.getTime();
                    helper.sendEmail(application.getEmail(), body, "Interview for myStore");
                    //notification to the manager 
                    User user = userdao.getUseridById(application.getUserID()+"");
        			notification.setUserId(userdao.getManagerId());
                    notification.setUserId(application.getUserID());
                    notification.setNotification("You have an interview scheduled for "+user.getFirstName()+" "+user.getLastName()+" on"+ interview.getDate());
   			        notification.setNotificationType("Interview Notification");
        			ns.createNotification(notification);
        			
                }
                return true;
            }
        }
        return false;
    }
    catch(Exception e){
        return false;
    } 
    }
}
