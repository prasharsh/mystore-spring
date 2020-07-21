package com.app.mystore.dao;

import java.util.ArrayList;
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

import com.app.mystore.dto.Complaint;
import com.app.mystore.dto.User;
import com.app.mystore.properties.ComplaintProperties;
import com.app.mystore.properties.UserProperties;
import com.app.mystore.rowmapper.ComplaintRowMapper;

@Repository
@Configuration
public class ComplaintDaoImpl extends JdbcDaoSupport implements ComplaintsDao{
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private UserDaoImpl userDao;

	@Autowired
	public  ComplaintProperties complaintproperties;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Complaint> getAllComplaints() throws Exception {
		List<Complaint> complaintList=null;
		try {
			complaintList=namedParameterJdbcTemplate.query(complaintproperties.getGetAllComplaints(), new ComplaintRowMapper());
			for(Complaint com:complaintList) {
				
				User user=userDao.getUseridById(String.valueOf(com.getUserId()));
				com.setComplaintUserName(user.getFirstName() +" "+ user.getLastName());
			}
		}
		catch (DataAccessException e) {

			throw new Exception("DB Issue, please contact support team");

		}
		return complaintList;
	}

	@Override
	public List<Complaint> getUserComplaints(int userId) throws Exception {
		List<Complaint> userComplaintList=null;
		namedSqlParams=new MapSqlParameterSource();
		try {
			namedSqlParams.addValue("userId", userId);
			userComplaintList=namedParameterJdbcTemplate.query(complaintproperties.getGetUserComplaints(),namedSqlParams, new ComplaintRowMapper());
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		return userComplaintList;
	}

	@Override
	public void createComplaint(Complaint complaint) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("complaintType", complaint.getComplaintType());
		namedSqlParams.addValue("userId", complaint.getUserId());
		namedSqlParams.addValue("complaint", complaint.getComplaintText());
		try {
			namedParameterJdbcTemplate.update(complaintproperties.getCreateComplaint(), namedSqlParams);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		
	}

	@Override
	public void updateResponse(Complaint complaint) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("response", complaint.getResponse());
		namedSqlParams.addValue("managerId", complaint.getManagerId());
		namedSqlParams.addValue("id", complaint.getId());
		
		try {
			namedParameterJdbcTemplate.update(complaintproperties.getUpdateResponse(), namedSqlParams);
		}
		catch (DataAccessException e) {

			throw new Exception("DB Issue, please contact support team");

		}
	}

}
