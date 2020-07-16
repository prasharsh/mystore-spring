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

@CrossOrigin
@RestController
@RequestMapping("/api/myStore/resignation")
public class ResignationController {

	@Autowired
	private  ResignationControllerService resignationControllerService;


	@PostMapping("/apply")
	public @ResponseBody String apply(@RequestBody Resignation  applyresignation){
		int  resign = resignationControllerService.apply(applyresignation);
		if( resign >= 1)
		return "Successfully Resigned";
		else 
		return "Failed to submit form";
	}
	
	@RequestMapping(value = "/edit/{rid}", method = RequestMethod.GET)
	@ResponseBody
	public Resignation getresignationdetails( @PathVariable("rid") int rid) {
		Resignation resign= new Resignation(); 
		resign =resignationControllerService.ResignationDetails(rid);
		return resign;
	}
	@Modifying
	@RequestMapping(value = "/delete/{rid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteResignation(@PathVariable("rid") int rid) {
		int result=0;
		result = resignationControllerService.DeleteResignation(rid);
		if (result ==1)
		return "Successfully deleted Resignation";
		else	
		return "Unable to delete";
		
	}
	

	

	
	
}
