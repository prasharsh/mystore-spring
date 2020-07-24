package com.app.mystore.controllers;

import com.app.mystore.dto.Application;
import com.app.mystore.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Author: Mitchell Moore
 * B00647455
 * Applicaiton controller is the controller to handle
 * all the requests to the /api/applications resources.
 * Contains all the endpoints for applicaitons for CRUD
 * and service operations
 */
@CrossOrigin
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	@GetMapping("/fetchAll")
	public List<Application> fetchAll() {
		return applicationService.fetchAll();
	}

	@GetMapping("/fetchByApplicationID/{applicationID}")
	public Application fetchByApplicationID(@PathVariable int applicationID) {
		return applicationService.fetchByApplicationID(applicationID);
	}

	@PutMapping("/updateApplication/{applicationID}")
	public Boolean updateApplication(@RequestBody Application updateApplication, @PathVariable int applicationID) {
		return applicationService.updateApplication(updateApplication);
	}

	@PostMapping("/insertApplication")
	public Boolean insertJobPost(@RequestBody Application newApplication) {
		return applicationService.addApplication(newApplication);
	}

	@DeleteMapping("/deleteApplication/{applicationID}")
	public Boolean deleteApplication( @PathVariable int applicationID) {
		return applicationService.deleteApplication(applicationID);
	}

	@PutMapping("/acceptApplication/{applicationID}")
	public Boolean acceptApplication(@PathVariable int applicationID){
		return applicationService.acceptApplication(applicationID);
	}
}
