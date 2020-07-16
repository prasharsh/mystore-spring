package com.app.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.JobPosting;
import com.app.mystore.service.JobPostingService;
import com.app.mystore.service.LoginControllerService;

@CrossOrigin
@RestController
@RequestMapping("/api/jobPosts")
public class JobPostingController {

	@Autowired
	private  JobPostingService jobPostingService;


	@GetMapping("/fetchAll")
	public List<JobPosting> fetchAll() {
		List<JobPosting> jobPostings = null;
		jobPostings = jobPostingService.fetchAll();
				
		return jobPostings;
	}


}
