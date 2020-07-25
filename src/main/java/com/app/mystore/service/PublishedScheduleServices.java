package com.app.mystore.service;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;
/*
* Author : Parth Panchal
* B00845025
* PublishedScheduleServices is an interface confirming the service call PublishedScheduleServicesImpl
* */
public interface PublishedScheduleServices {
    void saveSchedule(EmployeeSchedule employeeSchedule);
    ArrayList<EmployeeSchedule> retrieveSchedule();
}
