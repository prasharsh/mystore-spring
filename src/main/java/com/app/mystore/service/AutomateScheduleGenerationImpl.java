package com.app.mystore.service;

import com.app.mystore.dao.ScheduleDaoImpl;
import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.MappedTimings;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import com.app.mystore.service.ScheduleDecoderServices.DecodeGeneratedSchedule;
import com.app.mystore.service.scheduleGenerationAPIHandler.EncodeCrewAvailibility;
import com.app.mystore.service.scheduleGenerationAPIHandler.InitiateAPIRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * Author: Panchal Parth
 * B00845025
 * AutomateScheduleGenerationImpl faciliates the automatic schedule genration task using serveral other services such as
 * scheduleTimeMappings
 * encodeCrewAvailibility
 *initiateAPIRequest
 * decodeGeneratedSchedule
 */
@Service("AutomatedScheduleGeneration")
public class AutomateScheduleGenerationImpl implements AutomateScheduleGeneration  {

    @Autowired
    private ScheduleDaoImpl scheduleDaoimpl;

    @Autowired
    private ScheduleTimeMappingsImpl scheduleTimeMappings;

    @Autowired
    private EncodeCrewAvailibility encodeCrewAvailibility;

    @Autowired
    private InitiateAPIRequest initiateAPIRequest;

    @Autowired
    private DecodeGeneratedSchedule decodeGeneratedSchedule;



    @Override
    public ArrayList<EmployeeSchedule> requestScheduleFromAlgorithm() {
        ArrayList<ShiftDetails> shiftDetails = scheduleDaoimpl.getShiftDetails();
        ArrayList<avail> crewAvailList = scheduleDaoimpl.getAllAvailibility();
        System.out.println("size"+crewAvailList.size());
        ArrayList<MappedTimings> mappings = scheduleTimeMappings.generateMappings(crewAvailList,shiftDetails);
        ArrayList<ArrayList<ArrayList<Integer>>> data=encodeCrewAvailibility.encodeShifts(mappings);
        //System.out.println(initiateAPIRequest.returnScheduleSuggestions(data));
        System.out.println(encodeCrewAvailibility.crewMappings());
        String JSONStringResponseFromAlgorithm  = initiateAPIRequest.returnScheduleSuggestions(data);
        return decodeGeneratedSchedule.decodeService(JSONStringResponseFromAlgorithm,encodeCrewAvailibility.crewMappings(),shiftDetails);


    }

    @Override
    public int returnTotalCrew() {
        return scheduleDaoimpl.crewTally();
    }
}
