/**
 * Author: 	Khanjika Arora
 * Banner id: B00843319
 */

package com.app.mystore.controllers;
import com.app.mystore.dto.Manager;
import com.app.mystore.service.ManagerControllerService;
import com.google.gson.Gson;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/myStore/manager")
public class ManagerController {
	
	@Autowired
	private  ManagerControllerService managerControllerService;
	

	@RequestMapping(value = "/viewEmployee", method = RequestMethod.GET)
	@ResponseBody
	public List<Manager> viewLeaveRequest(){
		List <Manager> list=managerControllerService.viewEmployee();
		return list;
	}
	
	@RequestMapping(value = "/viewEmployee/delete/{id}", method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") int id) 
	{
		Gson gson =new Gson();
		String result;
		result = managerControllerService.DeleteEmployee(id);
		return gson.toJson(result);
		
	}
	
	


	
}
