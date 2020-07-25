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
                monStartTime = monStartTime.substring(0,5)+":00"+monStartTime.substring(5,7);
                monStartTime = timeConversionService.convertto24HourFormat(monStartTime);
                Date startTimings = format.parse(monStartTime);
                long difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setMonShift(difference);

                String tuesStartTime = a.getTuesStart();
                tuesStartTime = tuesStartTime.substring(0,5)+":00"+tuesStartTime.substring(5,7);
                tuesStartTime = timeConversionService.convertto24HourFormat(tuesStartTime);
                startTimings = format.parse(tuesStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setTueShift(difference);

                String wedStartTime = a.getWedStart();
                wedStartTime = wedStartTime.substring(0,5)+":00"+wedStartTime.substring(5,7);
                wedStartTime = timeConversionService.convertto24HourFormat(wedStartTime);
                startTimings = format.parse(wedStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setWedShift(difference);

                String thrusStartTime = a.getThrusStart();
                System.out.println("Thrus break :::::"+thrusStartTime);
                thrusStartTime = thrusStartTime.substring(0,5)+":00"+thrusStartTime.substring(5,7);
                thrusStartTime = timeConversionService.convertto24HourFormat(thrusStartTime);
                startTimings = format.parse(thrusStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setThursShift(difference);

                String friStartTime  = a.getFriStart();
                friStartTime = friStartTime.substring(0,5)+":00"+friStartTime.substring(5,7);
                friStartTime = timeConversionService.convertto24HourFormat(friStartTime);
                startTimings = format.parse(friStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setFriShift(difference);

                String satStartTime = a.getSatStart();
                satStartTime = satStartTime.substring(0,5)+":00"+satStartTime.substring(5,7);
                satStartTime = timeConversionService.convertto24HourFormat(satStartTime);
                startTimings = format.parse(satStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                mappedTimings.setSatShift(difference);

                String sunStartTime = a.getSunStart();
                sunStartTime = sunStartTime.substring(0,5)+":00"+sunStartTime.substring(5,7);
                sunStartTime = timeConversionService.convertto24HourFormat(sunStartTime);
                startTimings = format.parse(sunStartTime);
                difference = startTimings.getTime() - referralTimeDate.getTime();
                difference = difference/(1000*60*60);
                difference/=6;
                System.out.println("Difference : "+difference);
                mappedTimings.setSunShift(difference);
                timings.add(mappedTimings);
            }
        }catch (ParseException e){
            System.out.println(e);
        }
            System.out.println(" ResultSize : "+timings.size()+" "+timings.get(1).getSatShift() + " "+timings.get(2).getUserId());




        return timings;
    }



}
