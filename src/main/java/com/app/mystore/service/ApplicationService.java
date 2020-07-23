package com.app.mystore.service;

import com.app.mystore.dao.ApplicationDao;
import com.app.mystore.dao.NotificationsDao;
import com.app.mystore.dto.Application;
import com.app.mystore.dto.Notification;
import com.app.mystore.enums.NotificationTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ApplicationService")
public class ApplicationService {

    @Autowired
    public ApplicationDao dao;

    @Autowired
    private NotificationsDao notificationDao;

    public List<Application> fetchAll() {
        List<Application> applications = dao.fetchAll();
        return applications;
    }

    public Application fetchByApplicationID(int applicationID) {
        Application application = dao.getByApplicationID(applicationID);
        return application;
    }

    public Application fetchByUserID(int userID) {
        Application application = dao.getByUserID(userID);
        return application;
    }

    public Boolean updateApplication(Application updateApplication) {
        int result = dao.updateApplication(updateApplication);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean addApplication(Application newApplication) {
        int result = dao.insertApplication(newApplication);
        if(result > 0){
            int managerUserID = 6;
            String applicationNotification = "New application from " + newApplication.getFirstName();
            Notification notification = new Notification();
            NotificationTypeEnum notificationTypeEnum = NotificationTypeEnum.JOB_NOTIFICATION;
            notification.setUserId(managerUserID);
            notification.setNotification(applicationNotification);
            notification.setNotificationType(notificationTypeEnum.getType());
            try{
                notificationDao.createNotification(notification);
            }
            catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean deleteApplication(int applicationID) {
        int result = dao.deleteApplication(applicationID);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }
}
