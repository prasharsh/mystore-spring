package com.app.mystore.service;

import com.app.mystore.dao.ScheduleDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AutomatedScheduleGeneration")
public class AutomateScheduleGenerationImpl implements AutomateScheduleGeneration  {

    @Autowired
    private ScheduleDaoImpl scheduleDaoimpl;
    @Override
    public void generateMetrices() {


    }

    @Override
    public void encodeAvailibility() {
        scheduleDaoimpl.getShiftDetails();
    }

    @Override
    public int returnTotalCrew() {
        return scheduleDaoimpl.crewTally();
    }
}
