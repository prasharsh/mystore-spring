package com.app.mystore.dao;

import java.util.List;
import com.app.mystore.dto.JobPost;

public interface JobPostDao {

	List<JobPost> fetchAll();
    JobPost getByJobID(int jobId);
    int updateJobPost(JobPost jobPost);
    int insertJobPost(JobPost newJobPost);
}
