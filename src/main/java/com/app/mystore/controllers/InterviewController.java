package com.app.mystore.controllers;

import com.app.mystore.dto.Interview;
import com.app.mystore.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author: Mitchell Moore
 * B00647455
 * Interview controller is the controller to handle
 * all the requests to the /api/interview resources.
 * Contains all the endpoints for interview for create, read
 * and service operations
 */
@CrossOrigin
@RestController
@RequestMapping("/api/interview")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;

    /**
     * fetchByInterviewID takes an interviewID for a given interview and
     * returns an interview.
     * @param interviewID
     * @return an Interview object
     */
    @GetMapping("/fetchByInterviewID/{interviewID}")
    public Interview fetchByInterviewID(@PathVariable int interviewID) {
        return interviewService.fetchByInterviewID(interviewID);
    }

    /**
     * insertInterview takes an Interview object in the request body. This
     * is connected to the applicaiton managemnt page when a manager creates an
     * interview with an applicant.
     * @param interview
     * @return a Boolean true => create interview successful, false => create interview failed
     */
    @PostMapping("/insertInterview")
    public Boolean insertInterview(@RequestBody Interview interview) {
        return interviewService.addInterview(interview);
    }
}
