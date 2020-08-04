package com.app.mystore.service;

import com.app.mystore.dto.MappedTimings;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
* Author : Parth Panchal
* B00845025
* Encoding the plaintext time into shift number employing avail and ShiftDetails collections for feeding into
* remote NurseScheduling algorithm.
* */
@Service("GenerateMappings")
public class ScheduleTimeMappingsImpl implements ScheduleTimeMappings {

    @Autowired
    private TimeConversionServiceImpl timeConversionService;
    @Override
    public ArrayList<MappedTimings> generateMappings(ArrayList<avail> crewAvailibilityList, ArrayList<ShiftDetails> availiableshifts) {
        ArrayList<MappedTimings> timings = new ArrayList<>();
        String referralTime = "12:00:00AM";
        referralTime = timeConversionService.convertto24HourFormat(referralTime);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String[] splitter = new String[8];
        System.out.println("size"+crewAvailibilityList.size());

        try{
            Date referralTimeDate = format.parse(referralTime);
            for (avail a: crewAvailibilityList){
                MappedTimings mappedTimings = new MappedTimings();
                String UserId = a.getUsername();
                mappedTimings.setUserId(UserId);
                String monStartTime = a.getMonStart();
                if (monStartTime.isEmpty()){
                    mappedTimings.setMonShift(0);
                }
                else {
                    monStartTime = monStartTime.substring(0,5)+":00"+monStartTime.substring(5,7);
                    monStartTime = timeConversionService.convertto24HourFormat(monStartTime);
                    Date startTimings = format.parse(monStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setMonShift(difference);
                }


                String tuesStartTime = a.getTuesStart();
                if (tuesStartTime.isEmpty()){
                    mappedTimings.setTueShift(0);
                }
                else {
                    tuesStartTime = tuesStartTime.substring(0,5)+":00"+tuesStartTime.substring(5,7);
                    tuesStartTime = timeConversionService.convertto24HourFormat(tuesStartTime);
                    Date startTimings = format.parse(tuesStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setTueShift(difference);
                }


                String wedStartTime = a.getWedStart();
                if (wedStartTime.isEmpty()){mappedTimings.setWedShift(0);}
                else {
                    wedStartTime = wedStartTime.substring(0,5)+":00"+wedStartTime.substring(5,7);
                    wedStartTime = timeConversionService.convertto24HourFormat(wedStartTime);
                    Date startTimings = format.parse(wedStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setWedShift(difference);
                }


                String thrusStartTime = a.getThrusStart();
                if ( thrusStartTime .isEmpty()){
                    mappedTimings.setThursShift(0);
                }
                else {
                    System.out.println("Thrus break :::::"+thrusStartTime);
                    thrusStartTime = thrusStartTime.substring(0,5)+":00"+thrusStartTime.substring(5,7);
                    thrusStartTime = timeConversionService.convertto24HourFormat(thrusStartTime);
                    Date startTimings = format.parse(thrusStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setThursShift(difference);
                }
                String friStartTime  = a.getFriStart();
                if (friStartTime.isEmpty()){
                    mappedTimings.setFriShift(0);
                }
                else {
                    friStartTime = friStartTime.substring(0,5)+":00"+friStartTime.substring(5,7);
                    friStartTime = timeConversionService.convertto24HourFormat(friStartTime);
                    Date startTimings = format.parse(friStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setFriShift(difference);
                }


                String satStartTime = a.getSatStart();
                if (satStartTime.isEmpty()){
                    mappedTimings.setSatShift(0);
                }
                else {
                    satStartTime = satStartTime.substring(0,5)+":00"+satStartTime.substring(5,7);
                    satStartTime = timeConversionService.convertto24HourFormat(satStartTime);
                    Date startTimings = format.parse(satStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    mappedTimings.setSatShift(difference);
                }

                String sunStartTime = a.getSunStart();
                if (sunStartTime.isEmpty()){

                    mappedTimings.setSunShift(0);
                }
                else {
                    sunStartTime = sunStartTime.substring(0,5)+":00"+sunStartTime.substring(5,7);
                    sunStartTime = timeConversionService.convertto24HourFormat(sunStartTime);
                    Date startTimings = format.parse(sunStartTime);
                    long difference = startTimings.getTime() - referralTimeDate.getTime();
                    difference = difference/(1000*60*60);
                    difference/=6;
                    System.out.println("Difference : "+difference);
                    mappedTimings.setSunShift(difference);
                }
                timings.add(mappedTimings);
            }
        }catch (ParseException e){
            System.out.println(e);
        }
            System.out.println(" ResultSize : "+timings.size()+" "+timings.get(1).getSatShift() + " "+timings.get(2).getUserId());




        return timings;
    }



}
