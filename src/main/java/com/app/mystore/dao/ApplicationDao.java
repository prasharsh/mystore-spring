package com.app.mystore.dao;

import com.app.mystore.dto.Application;

import java.util.List;

public interface ApplicationDao {
    List<Application> fetchAll();
    Application getByApplicationID(int applicationID);
    Application getByUserID(int userID);
    int updateApplication(Application updateApplication);
    int insertApplication(Application newApplication);
    int deleteApplication(int applicationID);
}
