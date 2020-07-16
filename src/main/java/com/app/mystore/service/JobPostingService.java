package com.app.mystore.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.JobPostingDao;
import com.app.mystore.dao.ResetPasswordDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.JobPosting;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;

@Service("JobPostingService")
public class JobPostingService {
	
	@Autowired
	public JobPostingDao dao; 

	public List<JobPosting> fetchAll() {

		List<JobPosting> jobPosts = dao.fetchAll();
		
		return jobPosts;
	}

}
