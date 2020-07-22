package com.app.mystore.service;

import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleTimeMappingsImplTest {
    @Autowired
    ScheduleTimeMappings scheduleTimeMappings;
    @Test
    void generateMappings() {
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
        assertNotNull(scheduleTimeMappings.generateMappings(availArrayList,shifts));

    }
}