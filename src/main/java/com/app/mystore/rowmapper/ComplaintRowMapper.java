package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.Complaint;

public class ComplaintRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Complaint comp=new Complaint();
		comp.setComplaintDate(rs.getDate("complaint_date"));
		comp.setComplaintText(rs.getString("complaint"));
		comp.setComplaintType(rs.getString("complaint_type"));
		comp.setId(rs.getInt("id"));
		comp.setManagerId(rs.getInt("manager_id"));
		comp.setUserId(rs.getInt("user_id"));
		comp.setResponse(rs.getString("response"));
		return comp;
	}

}
