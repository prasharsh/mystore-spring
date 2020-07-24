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
	
	private String fetchallLeaveHistory;

	public String getFetchallLeaveHistory() {
		return fetchallLeaveHistory;
	}

	public void setFetchallLeaveHistory(String fetchallLeaveHistory) {
		this.fetchallLeaveHistory = fetchallLeaveHistory;
	}
	
	private String checkLeave;

	public String getCheckLeave() {
		return checkLeave;
	}

	public void setCheckLeave(String checkLeave) {
		this.checkLeave = checkLeave;
	}
	
	public String accept;

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}
	
	public String reject;

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
	}
	
	public String delete;

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}
	
	
}
