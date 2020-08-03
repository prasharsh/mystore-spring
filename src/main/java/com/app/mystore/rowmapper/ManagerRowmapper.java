/**
 * Author: 	Khanjika Arora
 * Banner id: B00843319
 */

package com.app.mystore.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.Manager;


public class ManagerRowmapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Manager manager = new Manager();
		manager.setFirst_name(rs.getString("first_name"));
		manager.setLast_name(rs.getString("last_name"));
		manager.setPhone(rs.getString("phone"));
		manager.setUser_name(rs.getString("user_name"));
		manager.setId(rs.getInt("id"));
		return manager;	
	}
}
