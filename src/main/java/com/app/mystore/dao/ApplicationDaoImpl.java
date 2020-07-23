package com.app.mystore.dao;

import com.app.mystore.dto.Application;
import com.app.mystore.properties.ApplicationProp;
import com.app.mystore.rowmapper.ApplicationRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
@Configuration
public class ApplicationDaoImpl extends JdbcDaoSupport implements ApplicationDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	public ApplicationProp applicationProp;

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
	public List<Application> fetchAll() {
		List<Application> applications = null;
		namedSqlParams=new MapSqlParameterSource();
		try {
			applications = namedParameterJdbcTemplate.query(applicationProp.getFetchAll(), new ApplicationRowMapper());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return applications;
	}

	@Override
	public Application getByApplicationID(int applicationID) {
		Application application = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("ApplicationID", applicationID);
		try {
			application=(Application)namedParameterJdbcTemplate.queryForObject(applicationProp.getGetByApplicationID(), namedSqlParams, new ApplicationRowMapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return application;
	}

	@Override
	public Application getByUserID(int userID) {
		Application application = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("UserID", userID);
		try {
			application=(Application)namedParameterJdbcTemplate.queryForObject(applicationProp.getGetByUserID(), namedSqlParams, new ApplicationRowMapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return application;
	}

	@Override
	public int updateApplication(Application updateApplication) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();

		namedSqlParams.addValue("FirstName", updateApplication.getFirstName());
		namedSqlParams.addValue("LastName", updateApplication.getLastName());
		namedSqlParams.addValue("Address", updateApplication.getAddress());
		namedSqlParams.addValue("Email", updateApplication.getEmail());
		namedSqlParams.addValue("PhoneNumber", updateApplication.getPhoneNumber());
		namedSqlParams.addValue("ApplicationID", updateApplication.getApplicationID());

		try {
			rows = namedParameterJdbcTemplate.update(applicationProp.getUpdateApplication(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}

	@Override
	public int insertApplication(Application newApplication) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();

		namedSqlParams.addValue("FirstName", newApplication.getFirstName());
		namedSqlParams.addValue("LastName", newApplication.getLastName());
		namedSqlParams.addValue("Address", newApplication.getAddress());
		namedSqlParams.addValue("Email", newApplication.getEmail());
		namedSqlParams.addValue("PhoneNumber", newApplication.getPhoneNumber());
		namedSqlParams.addValue("JobID", newApplication.getJobID());
		namedSqlParams.addValue("UserID", newApplication.getUserID());

		try {
			rows = namedParameterJdbcTemplate.update(applicationProp.getInsertApplication(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}

	@Override
	public int deleteApplication(int applicationID) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("ApplicationID", applicationID);

		try {
			rows = namedParameterJdbcTemplate.update(applicationProp.getDeleteApplication(), namedSqlParams);
		}
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
	}
}
