package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.Resignation;


public class ResignationRowmapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	Resignation resign=new Resignation();
	resign.setReason(rs.getString("reason"));
	resign.setEmpid(rs.getInt("empid"));
	resign.setStatus(rs.getString("status"));
	resign.setRid(rs.getInt("rid"));
	return resign;
	}

}