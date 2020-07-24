package com.app.mystore.dto;

import java.sql.Date;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * Announcement object to store all Announcement attributes.
 */
public class Announcement {
	
	private int id;
	private String announcement;
	private int managerId;
	private Date announcementDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnnouncement() {
		return announcement;
	}
	public void setAnnouncement(String announcement) {
		this.announcement = announcement;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Date getAnnouncementDate() {
		return announcementDate;
	}
	public void setAnnouncementDate(Date announcementDate) {
		this.announcementDate = announcementDate;
	}
	
	

}
