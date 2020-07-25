package com.app.mystore.controllers;

import com.app.mystore.dto.EmployeeSchedule;
import com.app.mystore.dto.avail;
import com.app.mystore.service.AutomateScheduleGenerationImpl;
import com.app.mystore.service.PublishedScheduleServicesImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.mystore.service.ScheduleService;

import java.util.ArrayList;
/*
* Author : Parth Panchal
* B00845025
* ScheduleController routes the service requests such as saving availability,generating schedule,
* retrieving and saving the published schedule.
* */
@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	Gson g = new Gson();
	@Autowired
	private  ScheduleService scheduleService;

	@Autowired
	private AutomateScheduleGenerationImpl automateScheduleGeneration;

	@Autowired
	private PublishedScheduleServicesImpl publishedScheduleServices;

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

	@PostMapping("/publishSchedule")
	public String publishSchedule(@RequestBody ArrayList<EmployeeSchedule> employeeSchedules){
		System.out.println("Inside Publish schedule + "+employeeSchedules.size());
		if (employeeSchedules.size() > 0){
			for(EmployeeSchedule employeeSchedule:employeeSchedules){
				publishedScheduleServices.saveSchedule(employeeSchedule);
			}
			return g.toJson("OK");
		}
		return g.toJson("Failed");
	}

	@GetMapping("/retrievePublishedSchedule")
	public ArrayList<EmployeeSchedule> retrieveSchedule(){
		ArrayList<EmployeeSchedule> employeeSchedules = publishedScheduleServices.retrieveSchedule();
		System.out.println(employeeSchedules.size());
		return employeeSchedules;
	}

}
