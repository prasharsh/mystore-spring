package com.app.mystore.service;

import com.app.mystore.dao.ScheduleDaoImpl;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("AutomatedScheduleGeneration")
public class AutomateScheduleGenerationImpl implements AutomateScheduleGeneration  {

    @Autowired
    private ScheduleDaoImpl scheduleDaoimpl;

    @Autowired
    private ScheduleTimeMappingsImpl scheduleTimeMappings;
    @Override
    public void generateMetrices() {

    }

    @Override
    public void encodeAvailibility() {
        ArrayList<ShiftDetails> shiftDetails = scheduleDaoimpl.getShiftDetails();
        ArrayList<avail> crewAvailList = scheduleDaoimpl.getAllAvailibility();
        scheduleTimeMappings.generateMappings(crewAvailList,shiftDetails);
    }

    @Override
    public int returnTotalCrew() {
        return scheduleDaoimpl.crewTally();
    }
}
