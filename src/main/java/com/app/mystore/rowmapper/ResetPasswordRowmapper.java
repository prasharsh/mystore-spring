package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public class ResetPasswordRowmapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		ResetPassword rp = new ResetPassword();
		rp.setId(rs.getInt("id"));
		rp.setUserid(rs.getInt("user_id"));
		rp.setToken(rs.getString("token"));
		rp.setStatus(rs.getString("status"));
		
		return rp;
	}


}
