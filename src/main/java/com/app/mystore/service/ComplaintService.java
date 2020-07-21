package com.app.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ComplaintsDao;
import com.app.mystore.dto.Complaint;

@Service("complaintService")
public class ComplaintService {
	
	@Autowired
	public ComplaintsDao complaintDao;
	
	
	private static ComplaintService uniqueInstance;
	
	private ComplaintService() {
	}
	
	public static ComplaintService instance(){
		if(null != uniqueInstance){
			uniqueInstance = new ComplaintService();
		}
		return uniqueInstance;
	}
	
	
	public List<Complaint> getAllComplaints() throws Exception{
		return complaintDao.getAllComplaints();
		
	}
	
	public List<Complaint> getUserComplaints(int userId) throws Exception{
		return complaintDao.getUserComplaints(userId);
	}
	
	public void createComplaint(Complaint complaint) throws Exception {
		complaintDao.createComplaint(complaint);
	}
	
	public void updateManagerResponse(Complaint complaint) throws Exception {
		complaintDao.updateResponse(complaint);
	}
	
	

}
