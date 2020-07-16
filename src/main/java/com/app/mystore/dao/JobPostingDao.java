package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.JobPosting;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public interface JobPostingDao {

	List<JobPosting> fetchAll();



}
