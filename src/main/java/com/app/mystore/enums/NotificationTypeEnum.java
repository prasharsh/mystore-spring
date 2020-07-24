package com.app.mystore.enums;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * Notification Type Enum which can be used to set notification type while creating notifications.
 */
public enum NotificationTypeEnum {
	LEAVE_NOTIFICATION("Leave Notification"),
	RESIGN_NOTIFICATION("Resign Notification"),
	SHIFT_NOTIFICATION("Shift Notification"),
	COMPLAINT_NOTIFICATION("Complaint Notification"),
	JOB_NOTIFICATION("Job Notification");
	
	private final String type;

	NotificationTypeEnum(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}
	
}
