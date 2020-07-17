package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.JobPost;

public class JobPostingRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		JobPost jp = new JobPost();
		
		jp.setJobID(rs.getInt("JobID"));
		jp.setDescription(rs.getString("Description"));
		jp.setPosition(rs.getString("Position"));
		jp.setRequirment(rs.getString("Requirment"));
		jp.setShift(rs.getString("Shift"));
		jp.setType(rs.getString("Type"));
		return jp;
	}


}
