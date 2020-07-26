/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 * LeaveDao is the interface that works with the LeaveDaoImpl 
 * to interact with the data base layer for crud operations
 */

package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Leave;

public interface LeaveDao {

	public String enterLeaveData(Leave leaveDetails, int empid);

	public List<Leave> pendingLeave();

	public List<Leave> leaveHistory(int empid);

	public String acceptLeave(Leave leave, int empid);

	public String rejectLeave(Leave leave, int empid);

	public String deleteLeave(int id);
	
}
