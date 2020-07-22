package com.app.mystore.service;

import com.app.mystore.dao.InterviewDao;
import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("InterviewService")
public class InterviewService {
    @Autowired
    public InterviewDao dao;

    public Interview fetchByInterviewID(int interviewID) {
        Interview interview = dao.getByInterviewID(interviewID);
        return interview;
    }

    public Boolean addInterview(Interview interview) {
        int result = dao.insertInterview(interview);
        if(result > 0){
            return true;
        }
        else{
            return false;
        }
    }

}
