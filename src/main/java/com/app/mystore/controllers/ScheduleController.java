package com.app.mystore.controllers;

import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.avail;
import com.app.mystore.service.AutomateScheduleGenerationImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.mystore.service.ScheduleService;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	Gson g = new Gson();
	@Autowired
	private  ScheduleService scheduleService;

	@Autowired
	private AutomateScheduleGenerationImpl automateScheduleGeneration;


	@PostMapping("/saveAvail")
	public String saveAvail(@RequestBody avail avail){

		System.out.println("User Name : "+avail.getUsername());
		int record = 0;
		record = scheduleService.saveAvail(avail);

		if(record> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}

	@GetMapping("/requestScheduleSuggest")
	public ArrayList<EmployeeSchedule> generate(){

		return automateScheduleGeneration.requestScheduleFromAlgorithm();
	}

}
