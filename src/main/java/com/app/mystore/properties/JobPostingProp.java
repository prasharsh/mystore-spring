package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/**
 * Author: Mitchell Moore
 * B00647455
 * JobPostingProp is used to get the SQL queries stored in the job_sql.properties file.
 */
@Configuration
@PropertySource("classpath:sql/job_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="job")
public class JobPostingProp {

	public JobPostingProp() {
		super();
	}

	private String fetchAll;
	private String getByJobID;
	private String updateJob;
	private String insertJob;
	private String deleteJob;

	public String getInsertJob() {
		return insertJob;
	}

	public void setInsertJob(String insertJob) {
		this.insertJob = insertJob;
	}

	public String getUpdateJob() {
		return updateJob;
	}

	public void setUpdateJob(String updateJob) {
		this.updateJob = updateJob;
	}

	public String getGetByJobID() {
		return getByJobID;
	}

	public void setGetByJobID(String getByJobID) {
		this.getByJobID = getByJobID;
	}

	public String getFetchAll() {
		return fetchAll;
	}

	public void setFetchAll(String fetchAll) {
		this.fetchAll = fetchAll;
	}

	public String getDeleteJob() {
		return deleteJob;
	}

	public void setDeleteJob(String deleteJob) {
		this.deleteJob = deleteJob;
	}
}
