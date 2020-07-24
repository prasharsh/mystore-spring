package com.app.mystore.service;

import com.app.mystore.dao.ApplicationDao;
import com.app.mystore.dao.ApplicationDaoImpl;
import com.app.mystore.dao.InterviewDao;
import com.app.mystore.dto.Application;
import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import com.app.mystore.utils.MystoreHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Author: Mitchell Moore
 * B00647455
 * InterviewService connects the controller to the doa class. It also generates and sends emails to users.
 */
@Service("InterviewService")
public class InterviewService {
    @Autowired
    public InterviewDao dao;

    @Autowired
    public ApplicationDaoImpl applicationDao;

    @Autowired
    public MystoreHelper helper;

    /**
     * fetchByInterviewID connects interview controller to interview dao.
     * @param interviewID
     * @return Interview object
     */
    public Interview fetchByInterviewID(int interviewID) {
        Interview interview = dao.getByInterviewID(interviewID);
        return interview;
    }

    /**
     * addInterview connects interview controller to interview dao to create a new interview. It also
     * sends an email to the applicant with the interview details.
     * @param interview
     * @return Boolean true => operations successful, false => operations failed.
     */
    public Boolean addInterview(Interview interview) {
        Application application = applicationDao.getByApplicationID(interview.getApplicationID());
        if (application != null) {
            int result = dao.insertInterview(interview);
            if (result > 0) {
                if (interview.getNotify().equals("true")) {
                    String body = "Hello,\n\n Thank you for your interest for working at myStore. We would like to set up an interview via: " + interview.getType() + " , on " + interview.getDate() + " , at " + interview.getTime();
                    helper.sendEmail(application.getEmail(), body, "Interview for myStore");
                }
                return true;
            }
        }
        return false;
    }
}
