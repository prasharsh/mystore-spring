
package com.app.mystore.service.scheduleGenerationAPIHandler;

import com.app.mystore.dto.MappedTimings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


@Service("EncodeCrewAvailibility")
public class EncodeCrewAvailibilityImpl implements EncodeCrewAvailibility {
    private HashMap<Integer, String> normalizeCrews;
    @Override
    public ArrayList<ArrayList<ArrayList<Integer>>> encodeShifts(ArrayList<MappedTimings> timings) {
        ArrayList<Integer> elements;
        ArrayList<ArrayList<Integer>> row;
        ArrayList<ArrayList<ArrayList<Integer>>> data = new ArrayList<>();
        normalizeCrews = new HashMap<>();
        Integer crewCounter = 0;
        for(MappedTimings mappedTimings:timings){
            row = new ArrayList<>();
            normalizeCrews.put(crewCounter,mappedTimings.getUserId());
            crewCounter++;
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getMonShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getTueShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getWedShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getThursShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getFriShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getSatShift()),1);
            row.add(elements);
            elements = new ArrayList<>(Arrays.asList(0,0,0,0));
            elements.set(Math.toIntExact(mappedTimings.getSunShift()),1);
            row.add(elements);
            data.add(row);
        }
        return data;
    }

    @Override
    public HashMap<Integer,String> crewMappings() {
        return normalizeCrews;
    }
}
