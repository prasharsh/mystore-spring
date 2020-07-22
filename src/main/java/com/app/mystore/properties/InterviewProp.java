package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/interview_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="interview")
public class InterviewProp {
    public InterviewProp() {
        super();
    }

    private String getByInterviewID;
    private String insertInterview;

    public String getGetByInterviewID() {
        return getByInterviewID;
    }

    public void setGetByInterviewID(String getByInterviewID) {
        this.getByInterviewID = getByInterviewID;
    }

    public String getInsertInterview() {
        return insertInterview;
    }

    public void setInsertInterview(String insertInterview) {
        this.insertInterview = insertInterview;
    }
}
