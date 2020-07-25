package com.app.mystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.StoreDetails;
import com.app.mystore.service.StoreDetailsService;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsController  is the controller to handle
 * all the requests to the /api/storeDetails resources.
 * Contains all the endpoints of Store details for Update operations
 */
@CrossOrigin
@RestController
@RequestMapping("/api/storeDetails")
public class StoreDetailsController {
	
	@Autowired
	private StoreDetailsService storeDetailsService;
	
	@PutMapping(path ="/updateStoreDetails")
	public String updateStoreDetails(@RequestBody StoreDetails details) {
		try {
			storeDetailsService.updateDetails(details);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		
	}
	@GetMapping("/getStoreDetails")
	public StoreDetails getDetails() {
		try {
			return storeDetailsService.getDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
