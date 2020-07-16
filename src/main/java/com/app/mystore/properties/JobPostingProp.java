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
	
	public String getFetchAll() {
		return fetchAll;
	}

	public void setFetchAll(String fetchAll) {
		this.fetchAll = fetchAll;
	}

	private String fetchAll;
	
}
