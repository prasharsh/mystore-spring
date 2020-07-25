package com.app.mystore.service.ScheduleDecoderServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.ShiftDetails;
import org.springframework.stereotype.Service;
/*
* Author : Parth Panchal
* B00845025
* DecodeGeneratedScheduleImpl decode the response generated from remote API call and converts it to
* Human readable format.
 * */
@Service("ScheduleDecoder")
public class DecodeGeneratedScheduleImpl implements DecodeGeneratedSchedule {

    @Override
    public ArrayList<EmployeeSchedule> decodeService(String JSONResponseFromAlgorithm, HashMap<Integer,String> crewMappings,ArrayList<ShiftDetails> shiftDetails) {
        System.out.println("algo response "+JSONResponseFromAlgorithm);
        ArrayList<EmployeeSchedule> employeeSchedules = new ArrayList<>();
        EmployeeSchedule employeeSchedule;
        HashMap<String,EmployeeSchedule> scheduleMappingsWithCrew = new HashMap<>();
       // try {
        HashMap<Integer,String> shiftTimings = mapTimings(shiftDetails);
            System.out.println("Crew Mappings:");
            for (int i=0; i<crewMappings.size(); ++i){
                System.out.println(i+ ""+crewMappings.get(i));
            }

            String[] dayMappings =  new String[7];
            dayMappings[0] = "Monday";
            dayMappings[1] = "Tuesday";
            dayMappings[2] = "Wednesday";
            dayMappings[3]="Thursday";
            dayMappings[4] = "Friday";
            dayMappings[5] = "Saturday";
            dayMappings[6] = "Sunday";
            Pattern p = Pattern.compile("\\d+");

            Matcher m = p.matcher(JSONResponseFromAlgorithm);

            System.out.println("Response JSON parser");

            int index = 0;
            Integer[] a = new Integer[3];
            while (m.find()){
               int i = Integer.parseInt(m.group());
               System.out.println("i: "+i);
               a[index] = i;

               if (index == 2){
                   index = 0;

                    int dayCode = a[0];
                    int crewCode = a[1];
                    int shiftCode = a[2];
                    String day = dayMappings[dayCode];
                    String userId = crewMappings.get(crewCode);
                    String timings = shiftTimings.get(shiftCode);
                    System.out.println("Crew Code: "+crewCode);

                    if(scheduleMappingsWithCrew.get(userId) == null){
                        employeeSchedule = new EmployeeSchedule();
                        employeeSchedule.setDay(day,timings);
                        employeeSchedule.setName(userId);
                        scheduleMappingsWithCrew.put(userId,employeeSchedule);
                    }
                    else {
                        EmployeeSchedule emp = scheduleMappingsWithCrew.get(userId);
                        emp.setDay(day,timings);
                        scheduleMappingsWithCrew.put(userId,emp);
                    }
               }
               else {
                   index++;
               }

            }
       // } catch (ParseException e) {
         //   e.printStackTrace();
        //}
        Set<String> keys = scheduleMappingsWithCrew.keySet();
        for (String key:keys){
            EmployeeSchedule emp = scheduleMappingsWithCrew.get(key);
            System.out.println(emp.getWed() + ""+emp.getName());
            employeeSchedules.add(emp);
        }
        return employeeSchedules;
    }

    private HashMap<Integer, String> mapTimings(ArrayList<ShiftDetails> shiftDetails) {
        HashMap<Integer,String> shiftMappings = new HashMap<>();
        for(ShiftDetails shiftDetail:shiftDetails){
            shiftMappings.put(shiftDetail.getNumber(),shiftDetail.getStart()+"-"+shiftDetail.getEnd());
        }
        return shiftMappings;
    }
}
