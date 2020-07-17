package com.app.mystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.User;
import com.app.mystore.service.LoginControllerService;
import com.app.mystore.service.ScheduleService;

@CrossOrigin
@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

	@Autowired
	private  ScheduleService scheduleService;


	@PostMapping("/saveAvail")
	public String saveAvail(@RequestBody Availability avail){

		int record = 0;
		record =scheduleService.saveAvail(avail);

		if(record> 0) {
			return "success";
		}
		return "failed";

	}

}
