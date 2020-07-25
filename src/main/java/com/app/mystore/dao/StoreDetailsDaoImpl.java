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

import com.app.mystore.dto.StoreDetails;
import com.app.mystore.properties.StoreDetailsProperties;
import com.app.mystore.rowmapper.AnnouncementRowMapper;
import com.app.mystore.rowmapper.StoreDetailsRowMapper;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsDaoImpl is the implementation of the StoreDetailsDao interface.
 * It provides the database operations for StoreDetails. StoreDetailsDaoImpl is responsible
 * to communicate with the database for StoreDetails CRUD operation.
 */
@Repository
@Configuration
public class StoreDetailsDaoImpl extends JdbcDaoSupport implements StoreDetailsDao{
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	private StoreDetailsProperties storeDetailProperties;
	
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
	public void updateStoreDetails(StoreDetails details) throws Exception {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("name", details.getStoreName());
		namedSqlParams.addValue("email", details.getStoreEmail());
		namedSqlParams.addValue("address", details.getAddress());
		namedSqlParams.addValue("id", details.getId());
		try {
			namedParameterJdbcTemplate.update(storeDetailProperties.getUpdateDetails(), namedSqlParams);
		}
		catch (DataAccessException e) {

			throw new Exception("DB Issue, please contact support team");

		}
		
	}
	@Override
	public StoreDetails getDetails() throws Exception {
		StoreDetails detail=null;
		try {
			detail=(StoreDetails) namedParameterJdbcTemplate.query(storeDetailProperties.getGetDetails(), new StoreDetailsRowMapper()).get(0);
		}
		catch (DataAccessException e) {
			e.printStackTrace();

			throw new Exception("DB Issue, please contact support team");

		}
		return detail;
	}

}
