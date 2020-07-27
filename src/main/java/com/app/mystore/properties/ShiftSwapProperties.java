package com.app.mystore.properties;
/**
 * Author: Prashant kumar
 * B00847456
 * UserProperties is the class that works with the sql property file 
 * user_sql.properties has the db queries for login module
 */


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/shiftSwap_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="swap")
public class ShiftSwapProperties {

	private String createSwapRequest;
	private String fetchSwapsByUid;
	private String acceptSwap;
	private String deleteSwap;
	private String shiftDefinedByUserName;
	private String updateSwapComment;
	public ShiftSwapProperties() {
		super();
	}
	
	private String fetchOpenSwapsByUid;
	
	
public String getCreateSwapRequest() {
		return createSwapRequest;
	}
	public void setCreateSwapRequest(String createSwapRequest) {
		this.createSwapRequest = createSwapRequest;
	}
	public String getFetchSwapsByUid() {
		return fetchSwapsByUid;
	}
	public void setFetchSwapsByUid(String fetchSwapsByUid) {
		this.fetchSwapsByUid = fetchSwapsByUid;
	}
	public String getAcceptSwap() {
		return acceptSwap;
	}
	public void setAcceptSwap(String acceptSwap) {
		this.acceptSwap = acceptSwap;
	}
	public String getDeleteSwap() {
		return deleteSwap;
	}
	public void setDeleteSwap(String deleteSwap) {
		this.deleteSwap = deleteSwap;
	}
	public String getShiftDefinedByUserName() {
		return shiftDefinedByUserName;
	}
	public void setShiftDefinedByUserName(String shiftDefinedByUserName) {
		this.shiftDefinedByUserName = shiftDefinedByUserName;
	}
	public String getUpdateSwapComment() {
		return updateSwapComment;
	}
	public void setUpdateSwapComment(String updateSwapComment) {
		this.updateSwapComment = updateSwapComment;
	}
	public String getFetchOpenSwapsByUid() {
		return fetchOpenSwapsByUid;
	}
	public void setFetchOpenSwapsByUid(String fetchOpenSwapsByUid) {
		this.fetchOpenSwapsByUid = fetchOpenSwapsByUid;
	}

	
}
