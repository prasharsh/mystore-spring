package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Announcement;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * AnnouncementsDao is an interface for all the DB operations required
 * for the  Announcements
 */
public interface AnnouncementsDao {
	
	public List<Announcement> getAllAnnouncements() throws Exception;
	public void createAnnouncement(Announcement announcement) throws Exception;
	public void deleteAnnouncement(int id) throws Exception;

}
