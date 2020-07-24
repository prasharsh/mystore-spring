package com.app.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Complaint;
import com.app.mystore.service.ComplaintService;

@CrossOrigin
@RestController
@RequestMapping("/api/complaints")
public class ComplaintsController {
	
	@Autowired
	private ComplaintService complaintService;
	
	@GetMapping("/getAllComplaints")
	public List<Complaint> getAllComplaints(){
		try {
			return complaintService.getAllComplaints();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping("/getComplaintsByUserId/{userId}")
	public List<Complaint> getUserComplaints(@PathVariable int userId){
		try {
			return complaintService.getUserComplaints(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path ="/createComplaint")
	public String createComplaint(@RequestBody Complaint complaint) {
		try {
			complaintService.createComplaint(complaint);
			return "Success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}
	
	@PutMapping(path ="/updateResponse")
	public String updateResponse(@RequestBody Complaint complaint) {
		try {
			complaintService.updateManagerResponse(complaint);;
			return "Success";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}
	
	@PutMapping("/deleteComplaint/{complaintId}")
	public String deleteComplaint(@PathVariable int complaintId) {
		try {
			complaintService.deleteComplaint(complaintId);
			return "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}


}
