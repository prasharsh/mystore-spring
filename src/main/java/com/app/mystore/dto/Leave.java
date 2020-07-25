/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 * Leave is data transfer object
 * for the leave table
 */


package com.app.mystore.dto;
import java.sql.Date;

import org.apache.commons.lang3.text.StrTokenizer;

public class Leave {
	
	private int id;
	private int empid;
	private String startdate; 
	private String enddate;
	private String reason;  
	private String status;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		if(startdate!=null && startdate.contains("T"))
		{
		startdate = startdate.substring(0, startdate.indexOf("T"));
		}
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		if(enddate!=null && enddate.contains("T"))
		enddate = enddate.substring(0, enddate.indexOf("T"));
		this.enddate = enddate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}  
	
}
