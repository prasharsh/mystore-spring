package com.app.mystore.dao;

import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
/**
 * Author: Mitchell Moore
 * B00647455
 * InterviewDao is an interface for all the operations required
 * for the Interview database to implement
 */
public interface InterviewDao {

    Interview getByInterviewID(int interviewId);
    int insertInterview(Interview interview);
}
