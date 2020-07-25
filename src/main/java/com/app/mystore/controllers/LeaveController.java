/**
 * Author: 	Khanjika Arora
 * Banner id: B00843319
 * LeaveController is the controller to handle
 * all the requests to the /api/myStore/leave.
 * Contains all the endpoints of leave module for CRUD operations
 */

package com.app.mystore.controllers;
import com.app.mystore.dto.Leave;
import com.app.mystore.dto.Resignation;
import com.app.mystore.dto.User;
import com.app.mystore.service.LeaveControllerService;
import com.app.mystore.service.LoginControllerService;
import com.google.gson.Gson;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/myStore/leave")
public class LeaveController {
	
	@Autowired
	private  LeaveControllerService leaveControllerService;
	
	@RequestMapping(value="/apply/{empid}")
	public String applyLeave (@RequestBody Leave leaveDetails, @PathVariable("empid") int empid){
		
		Gson g = new Gson();
		
		String leaveAppliedResponse= leaveControllerService.applyLeave(leaveDetails, empid);
		
		return g.toJson(leaveAppliedResponse);

	}
	
	@RequestMapping(value = "/viewLeaveRequest", method = RequestMethod.GET)
	@ResponseBody
	public List<Leave> viewLeaveRequest(){
		List <Leave> list=leaveControllerService.viewLeaveRequest();
		return list;
	}
	
	@RequestMapping(value = "/viewLeaveHistory/{empid}", method = RequestMethod.GET)
	@ResponseBody
	public List<Leave> viewLeaveHistory(@PathVariable("empid") int empid){
		List <Leave> list=leaveControllerService.viewLeaveHistory(empid);
		return list;

	}
	
	@RequestMapping(value="/viewLeaveRequest/accept/{empid}", method=RequestMethod.PUT)
	public String acceptLeave(@RequestBody Leave leave, @PathVariable int empid)
	{
		Gson gson =new Gson();
		String result= leaveControllerService.acceptLeave(leave,empid);
		return gson.toJson(result);
		
	}
	
	@RequestMapping(value="/viewLeaveRequest/reject/{empid}", method=RequestMethod.PUT)
	public String rejectLeave(@RequestBody Leave leave, @PathVariable int empid)
	{
		Gson gson =new Gson();
		String result= leaveControllerService.rejectLeave(leave,empid);
		return gson.toJson(result);
		
	}
	
	@RequestMapping(value = "/viewLeaveHistory/delete/{id}", method = RequestMethod.DELETE)
public String deleteLeave(@PathVariable("id") int id) 
	{
		Gson gson =new Gson();
		String result;
		result = leaveControllerService.DeleteResignation(id);
		return gson.toJson(result);
		
	}

	
}
