package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/*
 * Author : Parth Panchal
 * B00845025
 * The ScheduleProps fires the queries  stored in schedule_sql.properties
 * */
@Configuration
@PropertySource("classpath:sql/schedule_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="schedule")
public class ScheduleProps {
    String queryuniquecrews;

    public String getGetAllAvailibility() {
        return getAllAvailibility;
    }

    public void setGetAllAvailibility(String getAllAvailibility) {
        this.getAllAvailibility = getAllAvailibility;
    }

    String getAllAvailibility;
    public String getQueryuniquecrews() {
        return queryuniquecrews;
    }

    public void setQueryuniquecrews(String queryuniquecrews) {
        this.queryuniquecrews = queryuniquecrews;
    }

    public String getShiftmappings() {
        return shiftmappings;
    }

    public void setShiftmappings(String shiftmappings) {
        this.shiftmappings = shiftmappings;
    }

    String shiftmappings;


}
