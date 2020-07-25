package com.app.mystore.dao;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;

/*
* Author : Parth Panchal
* B00845025
* ublishscheduleDao is an interface confirming the PublishscheduleDao class.
* */

public interface PublishscheduleDao {
    public int insertSchedule(EmployeeSchedule employeeSchedules);
    public int updateSchedule(EmployeeSchedule employeeSchedules);
    public boolean isScheduleExist(String UserId);
    public ArrayList<EmployeeSchedule> retrieveSchedule();
}
