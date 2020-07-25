package com.app.mystore.service;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;

public interface AutomateScheduleGeneration {
    void generateMetrices();
    ArrayList<EmployeeSchedule> requestScheduleFromAlgorithm();
    int returnTotalCrew();
}
