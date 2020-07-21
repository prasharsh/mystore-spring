package com.app.mystore.dao;

import java.util.ArrayList;
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

import com.app.mystore.dto.Announcement;
import com.app.mystore.properties.AnnouncementProperties;
import com.app.mystore.rowmapper.AnnouncementRowMapper;

@Repository
@Configuration
public class AnnouncementsDaoImpl extends JdbcDaoSupport implements AnnouncementsDao{
	
	@Autowired
	private DataSource datasource;
	@Autowired
	private AnnouncementProperties announcementProperties;
	
	@Autowired
	private transient NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * @param namedParameterJdbcTemplate the namedParameterJdbcTemplate to set
	 */
	public void setNamedParameterJdbcTemplate(final NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	private transient MapSqlParameterSource namedSqlParams;
	
	@PostConstruct
	private void initialize(){
		setDataSource(datasource);

	}

	@Override
	public List<Announcement> getAllAnnouncements() throws Exception {
		List<Announcement> announcementList=new ArrayList();
		try {
			announcementList=namedParameterJdbcTemplate.query(announcementProperties.getGetAllAnnouncements(), new AnnouncementRowMapper());
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		return announcementList;
	}

	@Override
	public void createAnnouncement(Announcement announcement) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("announcement", announcement.getAnnouncement());
		namedSqlParams.addValue("managerId", announcement.getManagerId());
		try {
			namedParameterJdbcTemplate.update(announcementProperties.getCreateAnnouncement(), namedSqlParams);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
	}

	@Override
	public void deleteAnnouncement(int id) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		try {
			namedParameterJdbcTemplate.update(announcementProperties.getDeleteAnnouncement(), namedSqlParams);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		
	}

}
