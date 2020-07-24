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

	/**
	 * fetchAll returns all job posts in the database. This endpoint
	 * is used on the Careers and JobPost management pagee.
	 * @return List of JobPost
	 */
	@GetMapping("/fetchAll")
	public List<JobPost> fetchAll() {
		return jobPostService.fetchAll();
	}

	/**
	 * fetchByJobID takes a jobID as a parameter for a given job post. And returns
	 * the corresponding job post.
	 * @param jobId
	 * @return a JobPost object
	 */
	@GetMapping("/fetchByJobID/{jobId}")
	public JobPost fetchByJobID(@PathVariable int jobId) {
		return jobPostService.fetchByJobID(jobId);
	}

	/**
	 * updateJob takes a jobID as a parameter and a JobPost object in the request body. It returns a Boolean
	 * indicating the success of the update.
	 * @param updateJobPost
	 * @param jobId
	 * @return Boolean true => update JonPost successful, false => update JonPost failed
	 */
	@PutMapping("/updateJob/{jobId}")
	public Boolean updateJobPost(@RequestBody JobPost updateJobPost, @PathVariable int jobId) {
		return jobPostService.updateJobPost(updateJobPost);
	}

	/**
	 * insertJob takes a JobPost object in the request body. And returns a Boolean
	 * indicating the success of the create job post.
	 * @param newJobPost
	 * @return Boolean true => create JobPost successful, false => create JobPost failed
	 */
	@PostMapping("/insertJob")
	public Boolean insertJobPost(@RequestBody JobPost newJobPost) {
		return jobPostService.addJobPost(newJobPost);
	}

	/**
	 * deleteJob takes a jobId as a paramter in the URL for the job post to be deleted. And returns a Boolean
	 * 	 * indicating the success of the delete job post.
	 * @param jobID
	 * @return Boolean true => delete JobPost successful, false => delete JobPost failed
	 */
	@DeleteMapping("/deleteJob/{jobID}")
	public Boolean deleteApplication( @PathVariable int jobID) {
		return jobPostService.deleteJob(jobID);
	}
}
