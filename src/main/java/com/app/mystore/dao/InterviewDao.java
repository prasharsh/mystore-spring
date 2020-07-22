package com.app.mystore.dao;

import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;

public interface InterviewDao {

    Interview getByInterviewID(int interviewId);
    int insertInterview(Interview interview);
}
