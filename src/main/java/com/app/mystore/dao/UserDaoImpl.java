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

import com.app.mystore.dto.User;
import com.app.mystore.properties.UserProperties;
import com.app.mystore.rowmapper.UserRowmapper;

@Repository
@Configuration
public class UserDaoImpl extends JdbcDaoSupport implements UserDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	public  UserProperties userproperties;

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

	@SuppressWarnings("unchecked")
	@Override
	public User loadUserByUsername(User loginUser) throws EmptyResultDataAccessException {

		User user=new User();
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("username", loginUser.getUsername());
		namedSqlParams.addValue("password", loginUser.getPassword());
		try {
			user=(User)namedParameterJdbcTemplate.queryForObject(
					userproperties.getGetUser(), namedSqlParams, new UserRowmapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			user = null;
		}

		return user;

	}

}
