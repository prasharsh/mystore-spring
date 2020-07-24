package com.app.mystore.service;

import java.util.ArrayList;

import com.app.mystore.dto.avail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.AvailibilityDao;
import com.app.mystore.dto.Availability;

@Service("scheduleService")
public class ScheduleService {

	@Autowired
	public AvailibilityDao dao;

	public int saveAvail(avail avail) {


		int record = 0,rowsUpdated = 0;
		ArrayList<Availability> availabilities = new ArrayList<>();
		Availability availability;
		availability = new Availability();
		availability.setDay("Monday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getMonStart());
		availability.setEnd(avail.getMonEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Tuesday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getTuesStart());
		availability.setEnd(avail.getTuesEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Wednesday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getWedStart());
		availability.setEnd(avail.getWedEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Thrursday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getThrusStart());
		availability.setEnd(avail.getThrusEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Friday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getFriStart());
		availability.setEnd(avail.getFriEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Saturday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getSatStart());
		availability.setEnd(avail.getSatEnd());
		availabilities.add(availability);

		availability = new Availability();
		availability.setDay("Sunday");
		availability.setUserId(avail.getUsername());
		availability.setStart(avail.getSunStart());
		availability.setEnd(avail.getSunEnd());
		availabilities.add(availability);



		for(Availability availiability :availabilities){
			record = dao.saveAvail(availiability);
			rowsUpdated += record;
		}

		return rowsUpdated;
	}

	
}
