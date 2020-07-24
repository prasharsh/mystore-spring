package com.app.mystore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.mystore.dao.JobPostDao;
import com.app.mystore.dto.JobPost;
/**
 * Author: Mitchell Moore
 * B00647455
 * JobPostService connects the JobPost controller to the JobPost doa class.
 */
@Service("JobPostService")
public class JobPostService {
	
	@Autowired
	public JobPostDao dao;

	/**
	 * fetchAll connects JobPost controller to the JobPost doa. To get all JobPosts
	 * @return List JobPost
	 */
	public List<JobPost> fetchAll() {
		List<JobPost> jobPosts = dao.fetchAll();
		return jobPosts;
	}

	/**
	 * fetchByJobID connects JobPost controller to the JobPost doa. To get a specific JobPost
	 * @param jobId
	 * @return JobPost Object
	 */
    public JobPost fetchByJobID(int jobId) {
		JobPost jobPost = dao.getByJobID(jobId);
		return jobPost;
    }

	/**
	 * updateJobPost connects JobPost controller to the JobPost doa to update a JobPost.
	 * Converts the number of rows changed to a boolean.
	 * @param updateJobPost
	 * @return Boolean true => update success, false => update failed
	 */
	public Boolean updateJobPost(JobPost updateJobPost) {
		int result = dao.updateJobPost(updateJobPost);
		if(result > 0){
			return true;
		}
		else{
			return false;
		}
    }

	/**
	 * addJobPost connects JobPost controller to the JobPost doa to create a JobPost.
	 * Converts the number of rows changed to a boolean.
	 * @param newJobPost
	 * @return Boolean true => update success, false => update failed
	 */
	public Boolean addJobPost(JobPost newJobPost) {
		int result = dao.insertJobPost(newJobPost);
		if(result > 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * deleteJob connects JobPost controller to the JobPost doa to delete a JobPost.
	 * Converts the number of rows changed to a boolean.
	 * @param jobID
	 * @return Boolean true => update success, false => update failed
	 */
	public Boolean deleteJob(int jobID) {
		int result = dao.deleteJob(jobID);
		if(result > 0){
			return true;
		}
		else{
			return false;
		}
	}
}
