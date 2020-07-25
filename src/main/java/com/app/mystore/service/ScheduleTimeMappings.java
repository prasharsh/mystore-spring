package com.app.mystore.service;

import com.app.mystore.dto.MappedTimings;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;

import java.util.ArrayList;
/* Author : Parth Panchal
    B00845025
* Interface confirming the service called ScheduleTimeMappingsImpl
* */
public interface ScheduleTimeMappings {
    ArrayList<MappedTimings> generateMappings(ArrayList<avail> crewAvailibilityList, ArrayList<ShiftDetails> availiableshifts);
}
