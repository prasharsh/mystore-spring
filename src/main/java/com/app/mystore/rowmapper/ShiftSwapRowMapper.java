package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.ShiftSwap;
import com.app.mystore.dto.User;

public class ShiftSwapRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		// :swapDate , :shiftType , :swapComments , :swapRequestor , :swapStatus , :swappedWith
		ShiftSwap ss = new ShiftSwap();
		ss.setSwapId(rs.getInt("swapId"));
		ss.setShiftType(rs.getString("shiftType"));
		ss.setSwapComments(rs.getString("swapComments"));
		ss.setSwapDate(rs.getString("swapDate"));
		ss.setSwapId(rs.getInt("swapId"));
		ss.setSwappedWith(rs.getString("swappedWith"));
		ss.setSwapRequestor(rs.getString("swapRequestor"));
		return ss;
	}


}
