package com.app.mystore.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.properties.AvailProps;
import com.app.mystore.properties.UserProperties;
import com.app.mystore.rowmapper.ResetPasswordRowmapper;
import com.app.mystore.rowmapper.UserRowmapper;

@Repository
@Configuration
public class ScheduleDaoImpl extends JdbcDaoSupport implements ScheduleDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	public  AvailProps availProps;

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
	public int saveAvail(Availability avail) {

		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("userid", avail.getUserId());
		namedSqlParams.addValue("day", avail.getDay());
		namedSqlParams.addValue("start", avail.getStart());
		namedSqlParams.addValue("end", avail.getEnd());
		
		try {
			rows = namedParameterJdbcTemplate.update(availProps.getInsert(), namedSqlParams);	} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
		
	}
}
