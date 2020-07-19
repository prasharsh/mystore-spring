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

	public String applyLeave(Leave leaveDetails) {
		// TODO Auto-generated method stub
		return leaveDao.enterLeaveData(leaveDetails);
	}

	public List<Leave> viewLeaveRequest() {
		// TODO Auto-generated method stub
		List<Leave> pendingRequest = leaveDao.pendingLeave();
		return pendingRequest;
	}
	
	
	
	

}
