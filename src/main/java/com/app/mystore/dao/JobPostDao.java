package com.app.mystore.dao;

import java.util.List;
import com.app.mystore.dto.JobPost;
/**
 * Author: Mitchell Moore
 * B00647455
 * JobPostDao is an interface for all the operations required
 * for the JobPost database to implement
 */
public interface JobPostDao {

	List<JobPost> fetchAll();
    JobPost getByJobID(int jobId);
    int updateJobPost(JobPost jobPost);
    int insertJobPost(JobPost newJobPost);
    int deleteJob(int jobID);
}
