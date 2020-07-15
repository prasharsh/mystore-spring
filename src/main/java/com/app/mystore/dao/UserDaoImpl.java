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

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.properties.UserProperties;
import com.app.mystore.rowmapper.ResetPasswordRowmapper;
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

	@Override
	public User resetPasswordToken(String email) {
		User user = new User();
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("username", email);		
		try {
			user =(User) namedParameterJdbcTemplate.queryForObject(
					userproperties.getGetUserByUsername(), namedSqlParams, new UserRowmapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			user = null;
		}
		return user;
	}

	@Override
	public int registerUser(User newUser) {

		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("username", newUser.getUsername());
		namedSqlParams.addValue("password", newUser.getPassword());
		namedSqlParams.addValue("firstName", newUser.getFirstName());
		namedSqlParams.addValue("lastName", newUser.getLastName());
		namedSqlParams.addValue("phone", newUser.getPhone());
		
		try {
			rows = namedParameterJdbcTemplate.update(userproperties.getRegisterUser(), namedSqlParams);	} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
		
	}

	@Override
	public int updateUserProfiles(User updateForUser) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("username", updateForUser.getUsername());
		namedSqlParams.addValue("password", updateForUser.getPassword());
		namedSqlParams.addValue("firstName", updateForUser.getFirstName());
		namedSqlParams.addValue("lastName", updateForUser.getLastName());
		namedSqlParams.addValue("phone", updateForUser.getPhone());
		namedSqlParams.addValue("id", updateForUser.getId());
		
		try {
			rows = namedParameterJdbcTemplate.update(userproperties.getUpdateUser(), namedSqlParams);	} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
		
	}

	@Override
	public ResetPassword getUseridByToken(String token) {
		
		ResetPassword resetPassword = new ResetPassword();
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("token", token);
		try {
			resetPassword=(ResetPassword)namedParameterJdbcTemplate.queryForObject(
					userproperties.getDetailsByTokenId(), namedSqlParams, new ResetPasswordRowmapper());
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			resetPassword = null;
		}

		return resetPassword;

	}

	@Override
	public int updateUserPassword(User updatePasswordForUser) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("password", updatePasswordForUser.getPassword());
		namedSqlParams.addValue("id", updatePasswordForUser.getId());
		try {
			rows = namedParameterJdbcTemplate.update(userproperties.getResetPassword(), namedSqlParams);	} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
		
	}

	@Override
	public void InactivateResetPasswordToken(int id) {
		
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("id", id);
		try {
			namedParameterJdbcTemplate.update(userproperties.getInactivateToken(), namedSqlParams);	
		} 
		catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
