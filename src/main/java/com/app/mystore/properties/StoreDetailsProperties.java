package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsProperties is used to get the SQL queries stored in the store_details_sql.properties file.
 */
@Configuration
@PropertySource("classpath:sql/store_details_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="storedetails")
public class StoreDetailsProperties {
	private String updateDetails;

	private String getDetails;
	
	public String getUpdateDetails() {
		return updateDetails;
	}

	public void setUpdateDetails(String updateDetails) {
		this.updateDetails = updateDetails;
	}

	public String getGetDetails() {
		return getDetails;
	}

	public void setGetDetails(String getDetails) {
		this.getDetails = getDetails;
	}
	
	
	

}
