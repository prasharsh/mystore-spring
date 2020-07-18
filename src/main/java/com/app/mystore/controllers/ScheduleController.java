package com.app.mystore.controllers;

import com.app.mystore.dto.avail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.service.ScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

	@Autowired
	private  ScheduleService scheduleService;


	@PostMapping("/saveAvail")
	public String saveAvail(@RequestBody avail avail){

		int record = 0;
		record = scheduleService.saveAvail(avail);

		if(record> 0) {
			return "success";
		}
		return "failed";

	}

}
