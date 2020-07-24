package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/announcements_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="announcement")
public class AnnouncementProperties {
	private String getAllAnnouncements;
	private String createAnnouncement;
	private String deleteAnnouncement;
	public String getGetAllAnnouncements() {
		return getAllAnnouncements;
	}
	public void setGetAllAnnouncements(String getAllAnnouncements) {
		this.getAllAnnouncements = getAllAnnouncements;
	}
	public String getCreateAnnouncement() {
		return createAnnouncement;
	}
	public void setCreateAnnouncement(String createAnnouncement) {
		this.createAnnouncement = createAnnouncement;
	}
	public String getDeleteAnnouncement() {
		return deleteAnnouncement;
	}
	public void setDeleteAnnouncement(String deleteAnnouncement) {
		this.deleteAnnouncement = deleteAnnouncement;
	}
	
	

}
