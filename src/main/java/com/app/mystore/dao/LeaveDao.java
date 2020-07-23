package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Leave;

public interface LeaveDao {

	public String enterLeaveData(Leave leaveDetails, int empid);

	public List<Leave> pendingLeave();

	public List<Leave> leaveHistory(int empid);

	public String acceptLeave(Leave leave, int empid);

	public String rejectLeave(Leave leave, int empid);
	
}
