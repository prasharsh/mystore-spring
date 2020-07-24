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

	/**
	 * FetchAll endpoint fetchs all the applications in our
	 * system to display them all for the manager in the applicaiton
	 * manangemnt page.
	 * @return a List of applicaitons
	 */
	@GetMapping("/fetchAll")
	public List<Application> fetchAll() {
		return applicationService.fetchAll();
	}

	/**
	 * fetchByApplicationID takes an int as the applicaiton ID in the url as a
	 * parameter applicationID. It returns a single applicaiton with the given applicaitonID
	 * @param applicationID
	 * @return an Applicaiton object
	 */
	@GetMapping("/fetchByApplicationID/{applicationID}")
	public Application fetchByApplicationID(@PathVariable int applicationID) {
		return applicationService.fetchByApplicationID(applicationID);
	}

	/**
	 * updateApplication takes an int as the applicaitonID in the url for a given applicaiton to update
	 * and a applicaiton in the request body to use to update the applicaiton.
	 * @param updateApplication
	 * @param applicationID
	 * @return A boolean true => update successful, false => update failed
	 */
	@PutMapping("/updateApplication/{applicationID}")
	public Boolean updateApplication(@RequestBody Application updateApplication, @PathVariable int applicationID) {
		return applicationService.updateApplication(updateApplication);
	}

	/**
	 * insertApplication takes a applicaiton in the body request. This endpoint is used
	 * to create new applcations in our database and is directly used by the application page to
	 * send new applicaitons to the backend.
	 * @param newApplication
	 * @return A boolean true => create application successful, false => create application failed
	 */
	@PostMapping("/insertApplication")
	public Boolean insertJobPost(@RequestBody Application newApplication) {
		return applicationService.addApplication(newApplication);
	}

	/**
	 * deleteApplication takes an applicaitonID as a parameter in the URL.
	 * The applicationID is for a given application to be deleted.
	 * @param applicationID
	 * @return A boolean true => delete application successful, false => delete application failed
	 */
	@DeleteMapping("/deleteApplication/{applicationID}")
	public Boolean deleteApplication( @PathVariable int applicationID) {
		return applicationService.deleteApplication(applicationID);
	}

	/**
	 * acceptApplication takes an applicaitonID as a parameter in the URL.
	 * This is the endpoint invoked by the frontend when a manager approves an applicaiton.
	 * @param applicationID
	 * @return
	 */
	@PutMapping("/acceptApplication/{applicationID}")
	public Boolean acceptApplication(@PathVariable int applicationID){
		return applicationService.acceptApplication(applicationID);
	}
}
