package com.app.mystore.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.JobPosting;
import com.app.mystore.properties.JobPostingProp;
import com.app.mystore.rowmapper.JobPostingRowMapper;

@Repository
@Configuration
public class JobPostingDaoImpl extends JdbcDaoSupport implements JobPostingDao {

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

	@Override
	public List<JobPosting> fetchAll() {
		List<JobPosting> jobs = null;
		namedSqlParams=new MapSqlParameterSource();
		try {
		jobs = namedParameterJdbcTemplate.query(jobPostingProp.getFetchAll(), new JobPostingRowMapper());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return jobs;
	}

}
