package com.app.mystore.rowmapper;

import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InterviewRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Interview interview = new Interview();

        interview.setInterviewID(rs.getInt("InterviewID"));
        interview.setApplicationID(rs.getInt("ApplicationID"));
        interview.setType(rs.getString("Type"));
        interview.setDate(rs.getString("Date"));
        interview.setTime(rs.getString("Time"));
        interview.setNotify(rs.getString("Notify"));
        return interview;
    }
}
