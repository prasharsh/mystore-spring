package com.app.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.mystore.dto.JobPost;
import com.app.mystore.service.JobPostService;

/**
 * Author: Mitchell Moore
 * B00647455
 * JobPost controller is the controller to handle
 * all the requests to the /api/jobPosts resources.
 * Contains all the endpoints for JobPost for CRUD operations
 */
@CrossOrigin
@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController {

	@Autowired
	private JobPostService jobPostService;

	@GetMapping("/fetchAll")
	public List<JobPost> fetchAll() {
		return jobPostService.fetchAll();
	}

	@GetMapping("/fetchByJobID/{jobId}")
	public JobPost fetchByJobID(@PathVariable int jobId) {
		return jobPostService.fetchByJobID(jobId);
	}

	@PutMapping("/updateJob/{jobId}")
	public Boolean updateJobPost(@RequestBody JobPost updateJobPost, @PathVariable int jobId) {
		return jobPostService.updateJobPost(updateJobPost);
	}

	@PostMapping("/insertJob")
	public Boolean insertJobPost(@RequestBody JobPost newJobPost) {
		return jobPostService.addJobPost(newJobPost);
	}

	@DeleteMapping("/deleteJob/{jobID}")
	public Boolean deleteApplication( @PathVariable int jobID) {
		return jobPostService.deleteJob(jobID);
	}
}
