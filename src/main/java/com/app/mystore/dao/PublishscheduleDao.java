package com.app.mystore.dao;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;

public interface PublishscheduleDao {
    public int insertSchedule(EmployeeSchedule employeeSchedules);
    public int updateSchedule(EmployeeSchedule employeeSchedules);
    public boolean isScheduleExist(String UserId);
    public ArrayList<EmployeeSchedule> retrieveSchedule();
}
