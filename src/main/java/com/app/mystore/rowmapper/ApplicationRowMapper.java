package com.app.mystore.rowmapper;

import com.app.mystore.dto.Application;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * Author: Mitchell Moore
 * B00647455
 * ApplicationRowMapper is used to map the values returned from the database to create a new Application object
 */
public class ApplicationRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Application application = new Application();

		application.setApplicationID(rs.getInt("ApplicationID"));
		application.setUserID(rs.getInt("UserID"));
		application.setJobID(rs.getInt("JobID"));
		application.setAddress(rs.getString("Address"));
		application.setDate(rs.getString("Date"));
		application.setEmail(rs.getString("Email"));
		application.setFirstName(rs.getString("FirstName"));
		application.setLastName(rs.getString("LastName"));
		application.setPhoneNumber(rs.getString("PhoneNumber"));

		return application;
	}
}
