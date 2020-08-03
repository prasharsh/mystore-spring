package com.app.mystore.service;

import com.app.mystore.dto.EmployeeSchedule;

import java.util.ArrayList;
/**
 * Author: Panchal Parth
 * B00845025
 * interface for service AutomateScheduleGenerationImpl
 */
public interface AutomateScheduleGeneration {

    ArrayList<EmployeeSchedule> requestScheduleFromAlgorithm();
    boolean deactiveSwapRequest();
    int returnTotalCrew();
}
