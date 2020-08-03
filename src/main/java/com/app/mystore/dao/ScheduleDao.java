package com.app.mystore.dao;

import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;

import java.util.ArrayList;
/**
 * Author: Parth Panchal
 * B00845025
 * ScheduleDao is an interface confirming ScheduleDaoImpl.
 */
public interface ScheduleDao {
    int crewTally();
    ArrayList<avail> getAllAvailibility();
    ArrayList<ShiftDetails> getShiftDetails();
    int updateShiftSwapStatus();
}
