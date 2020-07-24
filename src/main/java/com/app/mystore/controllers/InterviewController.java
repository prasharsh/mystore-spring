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

    @GetMapping("/fetchByInterviewID/{interviewID}")
    public Interview fetchByInterviewID(@PathVariable int interviewID) {
        return interviewService.fetchByInterviewID(interviewID);
    }

    @PostMapping("/insertInterview")
    public Boolean insertInterview(@RequestBody Interview interview) {
        return interviewService.addInterview(interview);
    }
}
