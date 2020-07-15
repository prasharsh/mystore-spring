package com.app.mystore.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.ResetPassword;
import com.app.mystore.properties.UserProperties;
import com.app.mystore.rowmapper.ResetPasswordRowmapper;

@Repository
@Configuration
public class ResetPasswordDaoImpl extends JdbcDaoSupport implements ResetPasswordDao {

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

	@Override
	public int insertToken(ResetPassword rp) {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("userid", rp.getUserid());
		namedSqlParams.addValue("token", rp.getToken());
		ResetPassword resetPassword = new ResetPassword();
		try {
			rows = namedParameterJdbcTemplate.update(userproperties.getInsertResetPassword(), namedSqlParams);	} catch (DataAccessException e) {
			System.out.println(e.getMessage());
		}
		return rows;
		
	}

}
