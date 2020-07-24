package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * Author: Mitchell Moore
 * B00647455
 * ApplicationProp is used to get the SQL queries stored in the application_sql.properties file.
 */
@Configuration
@PropertySource("classpath:sql/application_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="application")
public class ApplicationProp {

    private String fetchAll;
    private String getByApplicationID;
    private String updateApplication;
    private String insertApplication;
    private String deleteApplication;
    private String getByUserID;

    public String getFetchAll() {
        return fetchAll;
    }

    public void setFetchAll(String fetchAll) {
        this.fetchAll = fetchAll;
    }

    public String getGetByApplicationID() {
        return getByApplicationID;
    }

    public void setGetByApplicationID(String getByApplicationID) {
        this.getByApplicationID = getByApplicationID;
    }

    public String getUpdateApplication() {
        return updateApplication;
    }

    public void setUpdateApplication(String updateApplication) {
        this.updateApplication = updateApplication;
    }

    public String getInsertApplication() {
        return insertApplication;
    }

    public void setInsertApplication(String insertApplication) {
        this.insertApplication = insertApplication;
    }

    public String getDeleteApplication() {
        return deleteApplication;
    }

    public void setDeleteApplication(String deleteApplication) {
        this.deleteApplication = deleteApplication;
    }

    public String getGetByUserID() {
        return getByUserID;
    }

    public void setGetByUserID(String getByUserID) {
        this.getByUserID = getByUserID;
    }
}
