package com.app.mystore.service.scheduleGenerationAPIHandler;

import com.app.mystore.dto.MappedTimings;

import java.util.ArrayList;
import java.util.HashMap;
/*
* Author : Parth Panchal
* B00845025
* EncodeCrewAvailibility confirming to EncodeCrewAvailibilityImpl
* */
public interface EncodeCrewAvailibility {
    ArrayList<ArrayList<ArrayList<Integer>>> encodeShifts(ArrayList<MappedTimings> timings);
    HashMap<Integer,String> crewMappings();
}
