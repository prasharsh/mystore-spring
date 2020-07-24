package com.app.mystore.dto;

import java.sql.Date;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * Complaint object to store all Complaint attributes.
 */
public class Complaint {

	private int id;
	private String complaintType;
	private String complaintUserName;
	private int userId;
	private String complaintText;
	private String response;
	private Date complaintDate;
	private int managerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComplaintType() {
		return complaintType;
	}
	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getComplaintText() {
		return complaintText;
	}
	public void setComplaintText(String complaintText) {
		this.complaintText = complaintText;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Date getComplaintDate() {
		return complaintDate;
	}
	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getComplaintUserName() {
		return complaintUserName;
	}
	public void setComplaintUserName(String complaintUserName) {
		this.complaintUserName = complaintUserName;
	}
	
	
	
	
}
