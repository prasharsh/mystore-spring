package com.app.mystore.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.app.mystore.dto.Resignation;
import com.app.mystore.rowmapper.ResignationRowmapper;
import com.app.mystore.rowmapper.ScheduleGenerationRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jdbc.repository.query.Modifying;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Configuration
public class ScheduleDaoImpl extends JdbcDaoSupport implements ScheduleDao {

	int rows =0;
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

		if (rows==0){
			deleteUser(avail.getUserId());
		}

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





	@Override
	@Modifying
	public int deleteUser(String UserId)
	{
		ScheduleGenerationRowmapper scheduleGenerationRowmapper = new ScheduleGenerationRowmapper();
		int result=0;
		Availability availability = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("userid", UserId);
		try {

			List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(
					availProps.getSelect(), namedSqlParams);

			if (list!= null)
			{

				result= namedParameterJdbcTemplate.update(availProps.getDelete(),namedSqlParams);

			}
			else
				result =0;
		}

		catch(DataAccessException e)
		{

			System.out.println(e.getMessage());
		}
		return result;

	}


}
