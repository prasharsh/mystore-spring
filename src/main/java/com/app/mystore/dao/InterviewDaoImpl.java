package com.app.mystore.dao;

import com.app.mystore.dto.Interview;
import com.app.mystore.dto.JobPost;
import com.app.mystore.properties.InterviewProp;
import com.app.mystore.properties.JobPostingProp;
import com.app.mystore.rowmapper.InterviewRowMapper;
import com.app.mystore.rowmapper.JobPostingRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
@Configuration
public class InterviewDaoImpl  extends JdbcDaoSupport implements InterviewDao{

    @Autowired
    private DataSource datasource;

    @Autowired
    public InterviewProp interviewProp;

    @Autowired
    private transient NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
     */
    public void setNamedParameterJdbcTemplate(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    private transient MapSqlParameterSource namedSqlParams;

    @PostConstruct
    private void initialize(){
        setDataSource(datasource);
    }

    @Override
    public Interview getByInterviewID(int interviewId) {
        Interview interview = null;
        namedSqlParams=new MapSqlParameterSource();
        namedSqlParams.addValue("InterviewID", interviewId);
        try {
            interview=(Interview)namedParameterJdbcTemplate.queryForObject(interviewProp.getGetByInterviewID(), namedSqlParams, new InterviewRowMapper());
        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
            interview = null;
        }
        return interview;
    }

    @Override
    public int insertInterview(Interview interview) {
        int rows =0;
        namedSqlParams=new MapSqlParameterSource();

        namedSqlParams.addValue("ApplicationID", interview.getApplicationID());
        namedSqlParams.addValue("Type", interview.getTime());
        namedSqlParams.addValue("Date", interview.getDate());
        namedSqlParams.addValue("Time", interview.getTime());
        namedSqlParams.addValue("Notify", interview.getNotify());

        try {
            rows = namedParameterJdbcTemplate.update(interviewProp.getInsertInterview(), namedSqlParams);
        }
        catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }
        return rows;
    }
}
