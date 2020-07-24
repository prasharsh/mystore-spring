package com.app.mystore.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.app.mystore.dto.JobPost;
import com.app.mystore.properties.JobPostingProp;
import com.app.mystore.rowmapper.JobPostingRowMapper;
/**
 * Author: Mitchell Moore
 * B00647455
 * JobPostDaoImpl is the implementation of the JobPostDao interface.
 * It provides the database operations for JobPost. JobPostDaoImpl is responsible
 * to communicate with the database for JobPosts CRUD operations.
 */
@Repository
@Configuration
public class JobPostDaoImpl extends JdbcDaoSupport implements JobPostDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	public  JobPostingProp jobPostingProp;

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

	/**
	 * fetchAll returns all the JobPosts in the database
	 * @return List of JobPosts
	 */
	@Override
	public List<JobPost> fetchAll() {
		List<JobPost> jobs = null;
		namedSqlParams=new MapSqlParameterSource();
		try {
		jobs = namedParameterJdbcTemplate.query(jobPostingProp.getFetchAll(), new JobPostingRowMapper());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jobs;
	}

	@Override
	public JobPost getByJobID(int jobId) {
		JobPost jobPost = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("JobID", jobId);
		try {
			jobPost=(JobPost)namedParameterJdbcTemplate.queryForObject(jobPostingProp.getGetByJobID(), namedSqlParams, new JobPostingRowMapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			jobPost = null;
		}
		return jobPost;
	}

	@Override
	public int insertJobPost(JobPost newJobPost) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();

		namedSqlParams.addValue("Type", newJobPost.getType());
		namedSqlParams.addValue("Shift", newJobPost.getShift());
		namedSqlParams.addValue("Position", newJobPost.getPosition());
		namedSqlParams.addValue("Requirment", newJobPost.getRequirment());
		namedSqlParams.addValue("Description", newJobPost.getDescription());

		try {
			rows = namedParameterJdbcTemplate.update(jobPostingProp.getInsertJob(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}

	@Override
	public int updateJobPost(JobPost jobPost) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();

		namedSqlParams.addValue("Type", jobPost.getType());
		namedSqlParams.addValue("Shift", jobPost.getShift());
		namedSqlParams.addValue("Position", jobPost.getPosition());
		namedSqlParams.addValue("Requirment", jobPost.getRequirment());
		namedSqlParams.addValue("Description", jobPost.getDescription());
		namedSqlParams.addValue("JobID", jobPost.getJobID());

		try {
			rows = namedParameterJdbcTemplate.update(jobPostingProp.getUpdateJob(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}

	@Override
	public int deleteJob(int jobID) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("JobID", jobID);

		try {
			rows = namedParameterJdbcTemplate.update(jobPostingProp.getDeleteJob(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}
}
