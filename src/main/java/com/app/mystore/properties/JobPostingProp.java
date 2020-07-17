package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
}
