package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.Notification;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * NotificationRowMapper is used to map the values returned from the database to create a new Notification object
 */
public class NotificationRowMapper implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notification not=new Notification();
		not.setId(rs.getInt("id"));
		not.setNotification(rs.getString("notification"));
		not.setNotificationDate(rs.getDate("notification_date"));
		not.setNotificationType(rs.getString("notification_type"));
		not.setUserId(rs.getInt("user_id"));
		return not;
	}

}
