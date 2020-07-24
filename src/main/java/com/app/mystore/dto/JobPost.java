package com.app.mystore.dto;
/**
 * Author: Mitchell Moore
 * B00647455
 * JobPost object to store all job post attributes
 */
public class JobPost {

	private int JobID;
	private String Position;
	private String Type;
	private String Shift;
	private String Requirment;
	private String Description;

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public String getPosition() {
		return Position;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getShift() {
		return Shift;
	}

	public void setShift(String shift) {
		Shift = shift;
	}

	public String getRequirment() {
		return Requirment;
	}

	public void setRequirment(String requirment) {
		Requirment = requirment;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
