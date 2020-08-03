/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 */

package com.app.mystore.properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/manager_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="manager")
public class ManagerProperties {
	
	public ManagerProperties() {
		super();
	}
	
	private String employeeList;

	public String getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(String employeeList) {
		this.employeeList = employeeList;
	}

	
}
