package com.app.mystore.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.app.mystore.dto.Leave;

public class LeaveHistoryRowmapper implements RowMapper{
	
	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Leave leave =new Leave();
		leave.setId(rs.getInt("id"));
		leave.setStartdate(rs.getString("startdate"));
		leave.setEnddate(rs.getString("enddate"));
		leave.setReason(rs.getString("reason"));
		leave.setStatus(rs.getString("status"));
		return leave;	
	}
}
