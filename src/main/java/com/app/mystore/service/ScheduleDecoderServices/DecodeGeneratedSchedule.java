package com.app.mystore.service.ScheduleDecoderServices;

import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.ShiftDetails;

import java.util.ArrayList;
import java.util.HashMap;
/*
* Author : Parth Panchal
* B00845025
*  DecodeGeneratedSchedule interface confirming to  DecodeGeneratedScheduleImpl
* */
public interface DecodeGeneratedSchedule {
    public ArrayList<EmployeeSchedule> decodeService(String JSONResponseFromAlgorithm, HashMap<Integer,String> crewMappings, ArrayList<ShiftDetails> shiftDetails);
}
