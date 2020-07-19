package com.app.mystore.dao;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;

import java.util.ArrayList;

public interface ScheduleDao {
    int crewTally();
    ArrayList<avail> getAllAvailibility();
    ArrayList<ShiftDetails> getShiftDetails();

}
