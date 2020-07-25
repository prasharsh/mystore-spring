package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
/*
* Author : Parth Panchal
* B00845025
* The AvailProps fires the query stored in avail_sql.properties
* */
@Configuration
@PropertySource("classpath:sql/avail_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="avail")
public class AvailProps {

	private String insert;
	private String select;

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	private String delete;


	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}



	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}
}
