package com.app.mystore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.mystore.dao.JobPostDao;
import com.app.mystore.dto.JobPost;

@Service("JobPostService")
public class JobPostService {
	
	@Autowired
	public JobPostDao dao;

	public List<JobPost> fetchAll() {
		List<JobPost> jobPosts = dao.fetchAll();
		return jobPosts;
	}

    public JobPost fetchByJobID(int jobId) {
		JobPost jobPost = dao.getByJobID(jobId);
		return jobPost;
    }

    public Boolean updateJobPost(JobPost updateJobPost) {
		int result = dao.updateJobPost(updateJobPost);
		if(result > 0){
			return true;
		}
		else{
			return false;
		}
    }

	public Boolean addJobPost(JobPost newJobPost) {
		int result = dao.insertJobPost(newJobPost);
		if(result > 0){
			return true;
		}
		else{
			return false;
		}
	}
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
