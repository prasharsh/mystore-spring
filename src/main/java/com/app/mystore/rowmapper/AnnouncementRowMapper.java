package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.Announcement;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * AnnouncementRowMapper is used to map the values returned from the database to create a new Announcement object
 */
public class AnnouncementRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Announcement anc=new Announcement();
		anc.setAnnouncement(rs.getString("announcement"));
		anc.setAnnouncementDate(rs.getDate("announcement_date"));
		anc.setId(rs.getInt("id"));
		anc.setManagerId(rs.getInt("manager_id"));
		return anc;
	}

}
