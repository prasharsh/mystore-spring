package com.app.mystore.dao;
import java.util.List; 
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.Resignation;
import com.app.mystore.properties.ResignationProperties;
import com.app.mystore.rowmapper.ResignationRowmapper;
import com.app.mystore.rowmapper.ViewAllResignationsRowmapper;


@Repository
@Configuration
public class ResignationDaoImpl extends JdbcDaoSupport implements ResignationDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	public  ResignationProperties resignationproperties;

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

	@SuppressWarnings({ "unchecked", "null" })
	@Override
	public int apply(Resignation resign, int empid) throws EmptyResultDataAccessException {
      
		int row= 0;
		
		namedSqlParams=new MapSqlParameterSource();
	    namedSqlParams.addValue("empid", empid);
	    
	   
		try {
			 resign= (Resignation) namedParameterJdbcTemplate.queryForObject(resignationproperties.getResignationDetails(), namedSqlParams, new ResignationRowmapper());
	   
		}
		
		catch (EmptyResultDataAccessException e) {
			namedSqlParams.addValue("reason", resign.getReason());
			row= namedParameterJdbcTemplate.update(resignationproperties.getApply(), namedSqlParams);
			System.out.println(e.getMessage());
		}
	
		return row;

	}
	@Override
	public String UpdateDetails(Resignation  resign, int empid)
	{
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("reason", resign.getReason());
		namedSqlParams.addValue("rid", resign.getRid());
		namedSqlParams.addValue("empid", empid);
		int row = namedParameterJdbcTemplate.update(resignationproperties.getUpdateResignation(), namedSqlParams);
		if(row==1)
		return "Success";
		else 
		return "Fail";
		
	}

	@Override
	public Resignation ResignationDetails(int empid) {
		Resignation resign = new Resignation();
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("empid", empid);		
		try {
			resign =(Resignation) namedParameterJdbcTemplate.queryForObject(
					resignationproperties.getViewBeforeEditResignation(), namedSqlParams, new ViewAllResignationsRowmapper());
		} catch (DataAccessException e) {
			resign=null;
			System.out.println(e.getMessage());
		}
		return resign;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Modifying
	public int DeleteResignation(int empid)
	{
		Resignation resign = new Resignation();
		int result=0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("empid", empid);	
try {
	resign= (Resignation) namedParameterJdbcTemplate.queryForObject(
			resignationproperties.getResignationDetails(), namedSqlParams, new ResignationRowmapper());
	if (resign!= null)
			{
	result= namedParameterJdbcTemplate.update(resignationproperties.getDeleteResignation(),namedSqlParams);
	
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
	@SuppressWarnings("unchecked")
	@Override
	public List<Resignation> GetAllResignation(){
		List<Resignation> allresignations= namedParameterJdbcTemplate.query(resignationproperties.getGetResignationDetails(), new ViewAllResignationsRowmapper()) ;
		
		return allresignations;

		
	}
	@Override
	public String  inactiveEmployee(int empid)
	{
		int result=0;
		namedSqlParams =new MapSqlParameterSource();
		
		namedSqlParams.addValue("empid", empid);
		try {
		result= namedParameterJdbcTemplate.update(resignationproperties.getAcceptResignation(), namedSqlParams);
		}

		catch(DataAccessException e)
		{
			System.out.println(e.getMessage());
		}
		if (result==1)
		return "Success";
			else 
		return "Fail";
	}
	@Override
	public String acceptResignation(Resignation resign, int empid) {
		int result =0;
		namedSqlParams =new MapSqlParameterSource();
	    namedSqlParams.addValue("rid", resign.getRid());
		namedSqlParams.addValue("empid", empid);
		try {
		result=namedParameterJdbcTemplate.update(resignationproperties.getChangeResignationStatusAccepted(),namedSqlParams);
		}
		catch (DataAccessException e){
			System.out.println(e.getMessage());	
		}
		if (result==1)
		return "Success";
		else 
		return "Fail";
		
	}
	
	@Override
	public String rejectResignation(Resignation resign, int empid) {
		int result =0;
		namedSqlParams =new MapSqlParameterSource();
	    namedSqlParams.addValue("rid", resign.getRid());
		namedSqlParams.addValue("empid", empid);
		try {
		result=namedParameterJdbcTemplate.update(resignationproperties.getChangeResignationStatusRejected(),namedSqlParams);
		}
		catch (DataAccessException e){
			System.out.println(e.getMessage());	
		}
		if (result==1)
		return "Success";
			else 
		return "Fail";
		
		
	}


	

}
