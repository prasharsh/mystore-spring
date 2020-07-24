package com.app.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.AnnouncementsDao;
import com.app.mystore.dto.Announcement;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * AnnouncementService connects the controller to the doa class.
 */
@Service("announcementService")
public class AnnouncementService {
	
	@Autowired
	private AnnouncementsDao announcementDao;
	
	public List<Announcement> getAllAnnoucements() throws Exception{
		return announcementDao.getAllAnnouncements();
	}
	
	public void createAnnouncement(Announcement annc) throws Exception {
		announcementDao.createAnnouncement(annc);
	}
	
	public void deleteAnnoncement(int id) throws Exception {
		announcementDao.deleteAnnouncement(id);
	}

}
