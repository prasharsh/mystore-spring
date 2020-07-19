package com.app.mystore.controllers;

import com.app.mystore.dto.avail;
import com.app.mystore.service.AutomateScheduleGenerationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.mystore.service.ScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

	@Autowired
	private  ScheduleService scheduleService;

	@Autowired
	private AutomateScheduleGenerationImpl automateScheduleGeneration;
	@PostMapping("/saveAvail")
	public String saveAvail(@RequestBody avail avail){

		int record = 0;
		record = scheduleService.saveAvail(avail);

		if(record> 0) {
			return "success";
		}
		return "failed";

	}

	@GetMapping("/requestScheduleSuggest")
	public void generate(){
		automateScheduleGeneration.returnTotalCrew();
		automateScheduleGeneration.encodeAvailibility();
	}

}
