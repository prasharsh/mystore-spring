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

@CrossOrigin
@RestController
@RequestMapping("/api/myStore/resignation")
public class ResignationController {

	@Autowired
	private  ResignationControllerService resignationControllerService;

//
//	@PostMapping("/apply/{empid}")
	
	@RequestMapping(value = "/apply/{empid}", method = RequestMethod.POST)
	public String apply(@RequestBody Resignation  applyresignation, @PathVariable int empid){
		int  resign = resignationControllerService.apply(applyresignation, empid);
		
		Gson gson = new Gson();
		if( resign == 1)
		return gson.toJson("Success");
		else 
		return gson.toJson("Fail");
	}
	
	@RequestMapping(value = "/edit/{empid}", method = RequestMethod.GET)
	@ResponseBody
	public Resignation getresignationdetails( @PathVariable("empid") int empid) {
		Resignation resign= new Resignation(); 
		resign =resignationControllerService.ResignationDetails(empid);
		if (resign != null)
		return resign;
		else
		return null;
	}
	
	@Modifying
	@CrossOrigin
	@RequestMapping(value = "/delete/{empid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteResignation(@PathVariable("empid") int empid) {
		int result=0;
		result = resignationControllerService.DeleteResignation(empid);
		Gson gson = new Gson();
		if (result ==1)
			return gson.toJson("Success");

		else	
			return gson.toJson("Fail");
		
	}
	

	

	
	
}
