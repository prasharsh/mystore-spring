package com.app.mystore.controllers;

import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import com.app.mystore.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
