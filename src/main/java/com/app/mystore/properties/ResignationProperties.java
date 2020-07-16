package com.app.mystore.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/resignation_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="resignation")
public class ResignationProperties {

	public ResignationProperties() {
		super();
	}

	private String apply;
	private String resignationDetails;
	private String deleteResignation;
	private String getResignationDetails;
	
	
	public String getGetResignationDetails() {
		return getResignationDetails;
	}
	public void setGetResignationDetails(String getResignationDetails) {
		this.getResignationDetails = getResignationDetails;
	}
	public String getDeleteResignation() {
		return deleteResignation;
	}
	public void setDeleteResignation(String deleteResignation) {
		this.deleteResignation = deleteResignation;
	}
	public String getApply() {
		return apply;
	}
	public void setApply(String apply) {
		this.apply = apply;
	}
	public String getResignationDetails() {
		return resignationDetails;
	}
	public void setResignationDetails(String resignationDetails) {
		this.resignationDetails = resignationDetails;
	}

	
}
