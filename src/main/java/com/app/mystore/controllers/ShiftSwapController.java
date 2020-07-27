package com.app.mystore.controllers;


import java.util.List;

/**
 * Author: Prashant kumar
 * B00847456
 * ShiftSwapController is the controller to handle
 * all the requests to the /api/myStore.
 * Contains all the endpoints of user module for CRUD operations
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.ShiftSwap;
import com.app.mystore.service.ShiftSwapService;
import com.google.gson.Gson;

@CrossOrigin
@RestController
@RequestMapping("/api/shift")
public class ShiftSwapController {

	@Autowired
	private  ShiftSwapService service;

	Gson g = new Gson();

	@PostMapping(path ="/createSwapRequest", consumes = "application/json", produces = "application/json")
	public String createSwapRequest(@RequestBody ShiftSwap  swapRequest){
		int rows= 0;
		try {
			rows = service.createSwapRequest(swapRequest);
		}catch (Exception e) {
			return g.toJson(e.getMessage());
		}


		if(rows> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}


	@GetMapping("/fetchSwapReqByUserid/{id}")
	public List<ShiftSwap> fetchSwapReqByUserid(
			@PathVariable("id") String id) {
		List<ShiftSwap> swaps= null;
		try {
			swaps =	service.getSwapsById(id);
		} catch (Exception e) {
			
			return swaps;
		}
		return swaps;

	}

	
	@GetMapping("/fetchOpenSwapReqByUserid/{id}")
	public List<ShiftSwap> fetchOpenSwapReqByUserid(
			@PathVariable("id") String id) {
		List<ShiftSwap> swaps= null;
		try {
			swaps =	service.getOpenSwapsById(id);
		} catch (Exception e) {
			
			return swaps;
		}
		return swaps;

	}



	@GetMapping("/acceptShift/{sid}/{uid}")
	public String acceptShift(
			@PathVariable("sid") String sid,
			@PathVariable("uid") String uid) {
		int rows;
		try {
			rows =	service.acceptShift(sid, uid);
		}catch (Exception e) {
			return g.toJson(e.getMessage());
		}


		if(rows> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}


	@GetMapping("/deleteShift/{sid}")
	public String deleteShift(
			@PathVariable("sid") String sid) {
		int rows;
		try {
			rows =	service.deleteShift(sid);
		}catch (Exception e) {
			return g.toJson(e.getMessage());
		}


		if(rows> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}
	
	@PutMapping("/updateShiftComments")
	public String updateShiftComment(
			@RequestBody ShiftSwap swapReq ) {
		int rows;
		try {
			rows =	service.updateShiftComment(swapReq);
		}catch (Exception e) {
			return g.toJson(e.getMessage());
		}


		if(rows> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}

	@GetMapping("/fetchShiftsByUsername/{username}")
	public List<ShiftSwap> fetchShiftsByUsername(
			@PathVariable("username") String username) {
		List<ShiftSwap> shifts= null;
		try {
			shifts =	service.getShiftByUsername(username);
		} catch (Exception e) {
			
			return shifts;
		}
		return shifts;

	}
}