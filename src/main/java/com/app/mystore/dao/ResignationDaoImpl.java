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
import com.app.mystore.properties.AnnouncementProperties;
import com.app.mystore.properties.ResignationProperties;
import com.app.mystore.rowmapper.ResignationRowmapper;
import com.app.mystore.rowmapper.ViewAllResignationsRowmapper;

/**
 * Author: Lavanya Nili
 * B00834718
 * ResignationDaoImpl  is the DAO implementation that interacts with the database for request/response
 * Contains the business logic
 */


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

	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * apply  is the DAO implementation method that lets the user apply a resignation
	 * Contains the business logic for POST method and the SQL query to insert 
	 * SQL returns an integer which states the number of rows effected
	 * this method return a string stating  success or failure 
	 */

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
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * UpdateDetails  is the DAO implementation method that lets the user update a resignation
	 * Contains the business logic for PUT method and the SQL query to update the tuple
	 * SQL Returns an integer which states the number of rows effected
	 *  this method return a string stating  success or failure 
	 */
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
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * ResignationDetails  is the DAO implementation method to get the resignation detials
	 * Contains the business logic for GET request by id 
	 * this method return an object of type resignation
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Resignation ResignationDetails(int empid) {
		Resignation resign = new Resignation();
		namedSqlParams=new MapSqlParameterSource();
		
		namedSqlParams.addValue("empid", empid);		
		try {
			resign =(Resignation) namedParameterJdbcTemplate.queryForObject(
					resignationproperties.getViewBeforeEditResignation(), namedSqlParams, new ViewAllResignationsRowmapper());
		} 
		catch (EmptyResultDataAccessException e) {
			
			System.out.println(e.getMessage());
		}
		return resign;
	}
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * DeleteResignation  is the DAO implementation method to delete the resignation 
	 * Contains the business logic for DELETE request by id 
	 * this method return an integer 
	 */
	
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
	resign= (Resignation) namedParameterJdbcTemplate.queryForObject(resignationproperties.getResignationDetails(), namedSqlParams, new ResignationRowmapper());
	result= namedParameterJdbcTemplate.update(resignationproperties.getDeleteResignation(),namedSqlParams);
}

catch (Exception e)
{
	System.out.println(e.getMessage());
}
		return result;
		
	}
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * GetAllResignation  is the DAO implementation method to get all the resignation requests for the manager
	 * Contains the business logic for get all request 
	 * this method return a list of resignation objects  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Resignation> GetAllResignation(){
		List<Resignation> allresignations= namedParameterJdbcTemplate.query(resignationproperties.getGetResignationDetails(), new ViewAllResignationsRowmapper()) ;
		
		return allresignations;

		
	}
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * inactiveEmployee  is the DAO implementation method to inactive a user if the resignation is accepted. 
	 * Contains the business logic for PUT request 
	 * this method return a string success or fail  
	 */
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
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * acceptResignation  is the DAO implementation for changing the user request status. 
	 * Contains the business logic for PUT request 
	 * this method return a string success or fail  
	 */
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
	
	/**
	 * Author: Lavanya Nili
	 * B00834718
	 * rejectResignation  is the DAO implementation for changing the user request status. 
	 * Contains the business logic for PUT request 
	 * this method return a string success or fail  
	 */
	
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
