package com.app.mystore.controllers;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.data.jdbc.repository.query.Modifying;
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

import com.app.mystore.dto.Resignation;
import com.app.mystore.service.ResignationControllerService;
import com.google.gson.Gson;


/**
 * Author: Lavanya Nili
 * B00834718
 * ActionOnResignation  is the controller to handle action taken on the resignation that is accept and reject
 * all the requests to the /api/mystore/requests resources.
 * Contains all the endpoints of the resignation operations handled by the manager
 */

@CrossOrigin
@RestController
@RequestMapping("/api/mystore/requests")

public class ActionOnResignation
{
	@Autowired
	private  ResignationControllerService resignationControllerService;
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * viewResignations is the method to handle viewing all the resignations applied
	 * It returns a list of resignation  objects
	 */
	
	@RequestMapping("/resignation")
	public List<Resignation> viewResignations(){
		List <Resignation> list=(List<Resignation>) resignationControllerService.viewResignation();
				return list;
		
	}
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * inactiveEmployee is the method to handle the user profile after accepting the resignation
	 * It deactivates the user and sends an email notification
	 * It returns a json result 
	 */
	
	
	@RequestMapping(value="/resignation/inactive/{empid}", method=RequestMethod.PUT)
	public String inactiveEmployee(@PathVariable int empid)
	{
		Gson gson =new Gson();
		String result= resignationControllerService.inactiveEmployee(empid);
		return gson.toJson(result);
		
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * acceptResignation is the method to handles the action accept 
	 * It changes the request status applied by the user
	 * It returns a json result 
	 */
	@RequestMapping(value="/resignation/accept/{empid}", method=RequestMethod.PUT)
	public String acceptResignation(@RequestBody Resignation resign, @PathVariable int empid)
	{   
		Gson gson =new Gson();
		String result= resignationControllerService.acceptResignation(resign,empid);
		if (result == null)
				{
			result ="Fail";
				return gson.toJson(result);
				}
		return gson.toJson(result);
		
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * rejectResignation is the method to handles the action reject 
	 * It changes the request status applied by the user
	 * It returns a json result 
	 */
	@RequestMapping(value="/resignation/reject/{empid}", method=RequestMethod.PUT)
	public String rejectResignation(@RequestBody Resignation resign, @PathVariable("empid") int empid)
	{
		Gson gson =new Gson();
		String result = resignationControllerService.rejectResignation(resign, empid);
		return gson.toJson(result);
	}
	
	
};

