package com.app.mystore.service.ScheduleDecoderServices;

import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.ShiftDetails;

import java.util.ArrayList;
import java.util.HashMap;

public interface DecodeGeneratedSchedule {
    public ArrayList<EmployeeSchedule> decodeService(String JSONResponseFromAlgorithm, HashMap<Integer,String> crewMappings, ArrayList<ShiftDetails> shiftDetails);
}
