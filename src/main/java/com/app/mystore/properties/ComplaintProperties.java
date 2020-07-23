package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/complaint_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="complaint")
public class ComplaintProperties {

	public ComplaintProperties() {
		super();
	}
	
	private String getAllComplaints;
	private String getUserComplaints;
	private String  createComplaint;
	private String updateResponse;
	private String deleteComplaint;
	public String getGetAllComplaints() {
		return getAllComplaints;
	}
	public void setGetAllComplaints(String getAllComplaints) {
		this.getAllComplaints = getAllComplaints;
	}
	public String getGetUserComplaints() {
		return getUserComplaints;
	}
	public void setGetUserComplaints(String getUserComplaints) {
		this.getUserComplaints = getUserComplaints;
	}
	public String getCreateComplaint() {
		return createComplaint;
	}
	public void setCreateComplaint(String createComplaint) {
		this.createComplaint = createComplaint;
	}
	public String getUpdateResponse() {
		return updateResponse;
	}
	public void setUpdateResponse(String updateResponse) {
		this.updateResponse = updateResponse;
	}
	public String getDeleteComplaint() {
		return deleteComplaint;
	}
	public void setDeleteComplaint(String deleteComplaint) {
		this.deleteComplaint = deleteComplaint;
	}
	
	
	
	
	
}
