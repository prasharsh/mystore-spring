package com.app.mystore.dao;

import com.app.mystore.dto.Application;

import java.util.List;
/**
 * Author: Mitchell Moore
 * B00647455
 * ApplicaitonDao is an interface for all the operations required
 * for the Applicaiton database to implement
 */
public interface ApplicationDao {
    List<Application> fetchAll();
    Application getByApplicationID(int applicationID);
    int updateApplication(Application updateApplication);
    int insertApplication(Application newApplication);
    int deleteApplication(int applicationID);
}
