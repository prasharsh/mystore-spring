package com.app.mystore.properties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/leave_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="leave")
public class LeaveProperties {
	
	public LeaveProperties() {
		super();
	}
	
	private String insertLeave;

	public String getInsertLeave() {
		return insertLeave;
	}

	public void setInsertLeave(String insertLeave) {
		this.insertLeave = insertLeave;
	}

	private String fetchall;

	public String getFetchall() {
		return fetchall;
	}

	public void setFetchall(String fetchall) {
		this.fetchall = fetchall;
	}
	

}
