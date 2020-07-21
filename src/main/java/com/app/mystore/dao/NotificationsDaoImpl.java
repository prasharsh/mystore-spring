package com.app.mystore.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.Notification;
import com.app.mystore.properties.NotificationProperties;
import com.app.mystore.rowmapper.AnnouncementRowMapper;
import com.app.mystore.rowmapper.NotificationRowMapper;

@Repository
@Configuration
public class NotificationsDaoImpl extends JdbcDaoSupport implements NotificationsDao {

	@Autowired
	private DataSource datasource;
	
	@Autowired
	private NotificationProperties notificationProperties;
	@Autowired
	private transient NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setNamedParameterJdbcTemplate(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private transient MapSqlParameterSource namedSqlParams;
	
	@PostConstruct
	private void initialize(){
		setDataSource(datasource);

	}
	@Override
	public List<Notification> getUserNotifications(int userId) throws Exception {
		List<Notification> notificationList=null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("userId", userId);
		try {
			notificationList=namedParameterJdbcTemplate.query(notificationProperties.getGetUserNotifications(), namedSqlParams,new NotificationRowMapper());
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		return notificationList;
	}

	@Override
	public void createNotification(Notification notification) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("notification", notification.getNotification());
		namedSqlParams.addValue("userId", notification.getUserId());
		namedSqlParams.addValue("notificationType", notification.getNotificationType());
		try {
			namedParameterJdbcTemplate.update(notificationProperties.getCreateNotification(), namedSqlParams);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		
	}

	@Override
	public void deleteNotification(int id) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		try {
			namedParameterJdbcTemplate.update(notificationProperties.getDeleteNotification(), namedSqlParams);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		
	}

}
