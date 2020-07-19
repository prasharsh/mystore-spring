package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Leave;

public interface LeaveDao {

	public String enterLeaveData(Leave leaveDetails);

	public List<Leave> pendingLeave();
	
}
