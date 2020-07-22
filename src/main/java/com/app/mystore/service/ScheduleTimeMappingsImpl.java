package com.app.mystore.service;

import com.app.mystore.dto.MappedTimings;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Service("GenerateMappings")
public class ScheduleTimeMappingsImpl implements ScheduleTimeMappings {

    @Autowired
    private TimeConversionServiceImpl timeConversionService;
    @Override
    public ArrayList<MappedTimings> generateMappings(ArrayList<avail> crewAvailibilityList, ArrayList<ShiftDetails> availiableshifts) {
        ArrayList<MappedTimings> timings = new ArrayList<>();
       /* String time1 = "12:00AM";
        String time2 = "01:01AM";
        String[] timesplit = time1.split(time1.substring(5,5));
        String trailTime;
        time1 = timeConversionService.convertto24HourFormat(time1);
        time2 = timeConversionService.convertto24HourFormat(time2);
        System.out.println("Time 1 : "+time1);
        System.out.println("Time 2 : "+time2);
        //https://www.programcreek.com/2014/01/how-to-calculate-time-difference-in-java/
        try{
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long difference = date2.getTime() - date1.getTime();
            System.out.println(difference/(1000*60*60));
        }catch (java.text.ParseException exception){} */
        ArrayList<InputTimings> inputTimingsList = new ArrayList<>();
        List<Future<AllocateShift>> jobResults;
        List<CompareTimings> tasks = new ArrayList<>();
        for(avail availRecord:crewAvailibilityList){
            InputTimings inputTimings = new InputTimings();
            String Timings = availRecord.getMonStart();
            String[] splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getMonEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(availRecord.getMonEnd());
            inputTimings.setDay("Monday");
            CompareTimings c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
            inputTimings = new InputTimings();
            Timings = availRecord.getTuesStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getTuesEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Tuesday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
            inputTimings = new InputTimings();
            Timings = availRecord.getWedStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getWedEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Wednesday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
            inputTimings = new InputTimings();
            Timings = availRecord.getThrusStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getThrusEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Thursday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
            inputTimings = new InputTimings();
            Timings = availRecord.getFriStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getFriEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Friday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
            inputTimings = new InputTimings();
            Timings = availRecord.getSatStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getSatEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Saturday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimings = new InputTimings();
            Timings = availRecord.getSunStart();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewStartTimings(Timings);
            Timings = availRecord.getSunEnd();
            splitter = Timings.split(Timings.substring(5,5));
            Timings = splitter[0]+":00"+splitter[1];
            inputTimings.setCrewEndTimings(Timings);
            inputTimings.setDay("Sunday");
            c = new CompareTimings(inputTimings);
            c.setShiftDetails(availiableshifts);
            tasks.add(c);
            inputTimingsList.add(inputTimings);
        }
        try {
            ExecutorService executor = Executors.newFixedThreadPool(300);
            jobResults = executor.invokeAll(tasks);
        }catch (InterruptedException e){
            System.out.println("JobExecution Failed");
        }

        return timings;
    }

    //https://stackoverflow.com/questions/2314402/return-values-from-java-threads
    class CompareTimings implements Callable<AllocateShift> {

        String crewStart;
        String crewEnd;
        int shiftNumber;
        String userId;
        String day;

        public ArrayList<ShiftDetails> getShiftDetails() {
            return shiftDetails;
        }

        public void setShiftDetails(ArrayList<ShiftDetails> shiftDetails) {
            this.shiftDetails = shiftDetails;
        }

        ArrayList<ShiftDetails> shiftDetails = new ArrayList<>();
        CompareTimings(InputTimings inputTimings){

            this.crewStart = inputTimings.getCrewStartTimings();
            this.crewEnd = inputTimings.getCrewEndTimings();
            this.shiftNumber = inputTimings.getShiftNumber();
            this.userId = inputTimings.getUserId();
            this.day = inputTimings.getDay();
        }

        @Override
        public AllocateShift call() throws Exception {
            AllocateShift allocateShift = new AllocateShift();
            try{
                SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");

                Date startShiftTiming1 = format.parse(shiftDetails.get(0).getStart());
                Date endShiftTiming1  = format.parse(shiftDetails.get(0).getEnd());
                Date startShiftTiming2 = format.parse(shiftDetails.get(1).getStart());
                Date endShiftTiming2  = format.parse(shiftDetails.get(1).getEnd());
                Date startShiftTiming3 = format.parse(shiftDetails.get(2).getStart());
                Date endShiftTiming3  = format.parse(shiftDetails.get(2).getEnd());
                Date startShiftTiming4 = format.parse(shiftDetails.get(3).getStart());
                Date endShiftTiming4  = format.parse(shiftDetails.get(3).getEnd());
                Date startCrewTimings = format.parse(this.crewStart);
                Date endCrewTimings  = format.parse(this.crewEnd);

                long diffStart1 = startShiftTiming1.getTime() - startCrewTimings.getTime();
                long diffStart2 = startShiftTiming2.getTime() - startCrewTimings.getTime();
                long diffStart3 = startShiftTiming3.getTime() - startCrewTimings.getTime();
                long diffStart4 = startShiftTiming4.getTime() - startCrewTimings.getTime();

                long diffEnd1 = endShiftTiming1.getTime() - endCrewTimings.getTime();
                long diffEnd2 = endShiftTiming2.getTime() - endCrewTimings.getTime();
                long diffEnd3  = endShiftTiming3.getTime() - endCrewTimings.getTime();
                long diffEnd4 = endShiftTiming4.getTime() - endCrewTimings.getTime();

                long[] startTimings = new long[4];
                long[] endTimings = new long[4];

                startTimings[0] = diffStart1;
                startTimings[1] = diffStart2;
                startTimings[2] = diffStart3;
                startTimings[3] = diffStart4;

                endTimings[0] = diffEnd1;
                endTimings[1] = diffEnd2;
                endTimings[2] = diffEnd3;
                endTimings[3] = diffEnd4;

                int ShiftCounter = 0;
                boolean successFlag =  false;
                do{
                    long spanOfShift = Math.abs(endCrewTimings.getTime() - startCrewTimings.getTime());
                    spanOfShift /= (1000 * 60 * 60);
                    if (spanOfShift > 1){
                        long startDifference = Math.abs(startCrewTimings.getTime() - startTimings[ShiftCounter]);
                        long endDifference = Math.abs(endCrewTimings.getTime() - startTimings[ShiftCounter]);
                        startDifference /= (1000 * 60 * 60);
                        endDifference /= (1000 * 60 * 60);
                        if((startDifference>=30 && startDifference<=60) && (endDifference>=30 && endDifference<=60)){

                            allocateShift.setDay(this.day);
                            allocateShift.setUserId(this.userId);
                            allocateShift.setShiftNumber(ShiftCounter);
                            successFlag = true;
                        }

                    }
                }while(successFlag!=true || ShiftCounter <5);

                if (successFlag!=true){

                    allocateShift.setDay(this.day);
                    allocateShift.setUserId(this.userId);
                    allocateShift.setShiftNumber(0);
                }

            }catch (java.text.ParseException exception){}
            return allocateShift;
        }
    }

    class AllocateShift{
        String day;
        int ShiftNumber;
        String UserId;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public int getShiftNumber() {
            return ShiftNumber;
        }

        public void setShiftNumber(int shiftNumber) {
            ShiftNumber = shiftNumber;
        }


    }

    class InputTimings{
        String crewStartTimings;
        String crewEndTimings;
        String userId;
        String day;
        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }


        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getShiftNumber() {
            return shiftNumber;
        }

        public void setShiftNumber(int shiftNumber) {
            this.shiftNumber = shiftNumber;
        }

        int shiftNumber;
        public String getCrewStartTimings() {
            return crewStartTimings;
        }

        public void setCrewStartTimings(String crewStartTimings) {
            this.crewStartTimings = crewStartTimings;
        }

        public String getCrewEndTimings() {
            return crewEndTimings;
        }

        public void setCrewEndTimings(String crewEndTimings) {
            this.crewEndTimings = crewEndTimings;
        }




    }
    public static void main(String[] args){
        ArrayList<avail> availArrayList = new ArrayList<>();
        ArrayList<ShiftDetails> shifts = new ArrayList<>();
        avail a = new avail();
        a.setUsername("Parth123");
        a.setMonStart("12:00AM");
        a.setMonEnd("2:00AM");
        a.setTuesStart("6:00PM");
        a.setTuesEnd("12:00AM");
        a.setWedStart("1:00AM");
        a.setWedEnd("4:00AM");
        a.setThrusStart("7:00PM");
        a.setThrusEnd("12:00AM");
        a.setFriStart("5:30PM");
        a.setFriEnd("1:00AM");
        a.setSatStart("12:00AM");
        a.setSatEnd("5:00AM");
        a.setSatStart("1:00AM");
        a.setSatEnd("7:00AM");
        availArrayList.add(a);
        ShiftDetails details = new ShiftDetails();
        details.setNumber(1);
        details.setStart("12:00:00AM");
        details.setEnd("06:00:00AM");
        shifts.add(details);
        details = new ShiftDetails();
        details.setNumber(2);
        details.setStart("06:00:00AM");
        details.setEnd("12:00:00PM");
        shifts.add(details);
        details = new ShiftDetails();
        details.setNumber(3);
        details.setStart("12:00:00PM");
        details.setEnd("06:00:00AM");
        shifts.add(details);
        details = new ShiftDetails();
        details.setNumber(4);
        details.setStart("06:00:00PM");
        details.setEnd("12:00:00AM");
        shifts.add(details);
        new ScheduleTimeMappingsImpl().generateMappings(availArrayList,shifts);
    }
}
