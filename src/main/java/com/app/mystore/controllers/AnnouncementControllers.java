package com.app.mystore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Announcement;
import com.app.mystore.service.AnnouncementService;

@CrossOrigin
@RestController
@RequestMapping("/api/annoucements")
public class AnnouncementControllers {

	@Autowired
	private AnnouncementService announcementService;
	
	@GetMapping("/getAllAnnouncements")
	public List<Announcement> getAllAnnouncements(){
		try {
			return announcementService.getAllAnnoucements();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path ="/createAnnouncement")
	public String createAnnouncement(@RequestBody Announcement announcement) {
		try {
			announcementService.createAnnouncement(announcement);
			return "Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failure";
		}
	}
	
	@PutMapping("/deleteAnnoucement/{announcementId}")
	public String deleteAnnouncement(@PathVariable int announcementId) {
		try {
			announcementService.deleteAnnoncement(announcementId);
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failure";
		}
		
	}
}
