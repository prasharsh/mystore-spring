package com.app.mystore.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.app.mystore.rowmapper.ScheduleGenerationRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.Availability;
import com.app.mystore.properties.AvailProps;

import java.util.List;
import java.util.Map;

@Repository
@Configuration
public class AvailibilityDaoImpl extends JdbcDaoSupport implements AvailibilityDao {

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
			this.deleteUser(avail.getUserId());
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
	public int deleteUser(String UserId) {

		int result=0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("userid", UserId);
		try {

			List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(
					availProps.getSelect(), namedSqlParams);

			if (list!= null)
			{

				result= namedParameterJdbcTemplate.update(availProps.getDelete(),namedSqlParams);
				System.out.println("Delete method called");
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
