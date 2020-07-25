package com.app.mystore.service;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;

public interface PublishedScheduleServices {
    void saveSchedule(EmployeeSchedule employeeSchedule);
    ArrayList<EmployeeSchedule> retrieveSchedule();
}
