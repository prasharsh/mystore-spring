

package com.app.mystore.dto;
/*
* Author : Parth Panchal
* B00845025
* Availability model holds the timings in joint formats for encoding purposes.
*/
public class Availability {
	private String userId;
	private String day  ;
	private String start ;
	private String end ;



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
}
