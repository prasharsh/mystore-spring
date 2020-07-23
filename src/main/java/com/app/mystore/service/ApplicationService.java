package com.app.mystore.service;

import com.app.mystore.dao.ApplicationDao;
import com.app.mystore.dto.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ApplicationService")
public class ApplicationService {

    @Autowired
    public ApplicationDao dao;

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
