package com.app.mystore.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.app.mystore.dto.Leave;

public class LeaveRowmapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Leave leave =new Leave();
		leave.setEmpid(rs.getInt("empid"));
		leave.setStartdate(rs.getDate("startdate"));
		leave.setEnddate(rs.getDate("enddate"));
		leave.setReason(rs.getString("reason"));
		leave.setName(rs.getString("name"));
		return leave;	
	}
}
