package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Complaint;

public interface ComplaintsDao {
	
	public List<Complaint> getAllComplaints() throws Exception;
	public List <Complaint> getUserComplaints(int userId)  throws Exception;
	public void createComplaint(Complaint complaint) throws Exception;
	public void updateResponse(Complaint complaint) throws Exception;
	public void delteComplaint(int id) throws Exception;

}
