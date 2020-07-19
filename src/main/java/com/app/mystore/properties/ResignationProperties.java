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
	private String checkifResignationExits;
	private String resignationDetails;
	private String updateResignation;
	private String deleteResignation;
	private String getResignationDetails;
	private String viewBeforeEditResignation;	
	private String acceptResignation;
	private String changeResignationStatus;
	
	public String getChangeResignationStatus() {
		return changeResignationStatus;
	}
	public void setChangeResignationStatus(String changeResignationstatus) {
		this.changeResignationStatus = changeResignationStatus;
	}
	public String getAcceptResignation() {
		return acceptResignation;
	}
	public void setAcceptResignation(String acceptResignation) {
		this.acceptResignation = acceptResignation;
	}
	public String getCheckifResignationExits() {
		return checkifResignationExits;
	}
	public void setCheckifResignationExits(String checkifResignationExits) {
		this.checkifResignationExits = checkifResignationExits;
	}
	

	public String getUpdateResignation() {
		return updateResignation;
	}
	public void setUpdateResignation(String updateResignation) {
		this.updateResignation = updateResignation;
	}
	public String getViewBeforeEditResignation() {
		return viewBeforeEditResignation;
	}
	public void setViewBeforeEditResignation(String viewBeforeEditResignation) {
		this.viewBeforeEditResignation = viewBeforeEditResignation;
	}
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
