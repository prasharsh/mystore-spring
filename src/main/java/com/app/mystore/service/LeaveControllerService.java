package com.app.mystore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.mystore.dao.LeaveDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Leave;

@Service("leaveControllerService")
public class LeaveControllerService {
	
	@Autowired
	public LeaveDao leaveDao;

	public String applyLeave(Leave leaveDetails, int empid) {
		// TODO Auto-generated method stub
		return leaveDao.enterLeaveData(leaveDetails, empid);
	}

	public List<Leave> viewLeaveRequest() {
		// TODO Auto-generated method stub
		List<Leave> pendingRequest = leaveDao.pendingLeave();
		return pendingRequest;
	}

	public List<Leave> viewLeaveHistory(int empid) {
		// TODO Auto-generated method stub
		List<Leave> leaveHistory = leaveDao.leaveHistory(empid);
		return leaveHistory;
	}

	public String acceptLeave(Leave leave, int empid) {
		String result=leaveDao.acceptLeave(leave, empid);
		return result;
	}

	public String rejectLeave(Leave leave, int empid) {
		String result=leaveDao.rejectLeave(leave, empid);
		return result;
	}
	
	
	
	

}
