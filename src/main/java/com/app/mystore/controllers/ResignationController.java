package com.app.mystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Resignation;
import com.app.mystore.service.ResignationControllerService;
import com.google.gson.Gson;

/**
 * Author: Lavanya Nili
 * B00834718
 * ResignationController  is the controller to handle employee separation
 * all the requests to the /api/myStore/resignation resources.
 * Contains all the endpoints of the resignation operations
 */

@CrossOrigin
@RestController
@RequestMapping("/api/myStore/resignation")
public class ResignationController {

	@Autowired
	private  ResignationControllerService resignationControllerService;

	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * apply  is the method to handle applying the resignation
	 * It checks if user has previously applied or not and then lets the user apply.
	 * return result as a json string
	 */

	@RequestMapping(value = "/apply/{empid}", method = RequestMethod.POST)
	public String apply(@RequestBody Resignation  applyresignation, @PathVariable int empid)
	{
		int  resign = resignationControllerService.apply(applyresignation, empid);
		Gson gson = new Gson();
		if( resign == 1)
		return gson.toJson("Success");
		else 
		return gson.toJson("Fail");
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * getresignationdetails  is the method to get the resignation details
	 * It fetches teh resignation details applied by the user only where the status of teh resignation is not accepted/rejected
	 * return result as a json string
	 */
	
	
	@RequestMapping(value = "/edit/{empid}", method = RequestMethod.GET)
	@ResponseBody
	public Resignation getresignationdetails( @PathVariable("empid") int empid) 
	{
		Resignation resign= new Resignation(); 
		resign =resignationControllerService.ResignationDetails(empid);
		if (resign != null)
		return resign;
		else
		return null;
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * update  is the method to get the update the resignation details
	 * It fetches the resignation id and then captures the reason and updates the resignation
	 * return result as a json string
	 */
	
	
	@RequestMapping(value="/update/{empid}", method=RequestMethod.PUT)
	public String update(@RequestBody Resignation Editresign, @PathVariable("empid") int empid)
	{
		Gson gson= new Gson();
		
	    String update = resignationControllerService.UpdateResignation(Editresign, empid); 
		return gson.toJson(update);
		
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * deleteResignation  is the method to delete the resignation  applied
	 * return result as a json string
	 */
	
	@RequestMapping(value = "/delete/{empid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteResignation(@PathVariable("empid") int empid) 
	{
		int result=0;
		result = resignationControllerService.DeleteResignation(empid);
		Gson gson = new Gson();
		if (result ==1)
			return gson.toJson("Success");

		else	
			return gson.toJson("Fail");
		
	}
	
}
