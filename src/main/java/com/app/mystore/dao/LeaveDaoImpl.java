/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 * LeaveDaoImpl is the dao implementation 
 * to interact with the data base layer for crud operations
 */

package com.app.mystore.dao;
import java.util.List;
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
import com.app.mystore.dto.Leave;
import com.app.mystore.dto.User;
import com.app.mystore.properties.LeaveProperties;
import com.app.mystore.rowmapper.LeaveRowmapper;
import com.app.mystore.rowmapper.LeaveHistoryRowmapper;
import com.app.mystore.rowmapper.UserRowmapper;

@Repository
@Configuration
public class LeaveDaoImpl extends JdbcDaoSupport implements LeaveDao{
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	public  LeaveProperties leaveproperties;
	
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
	public String enterLeaveData(Leave leaveDetails, int empid) {
		// TODO Auto-generated method stub
		Leave result = null;
		String value="";
		int insert = 0;
		namedSqlParams=new MapSqlParameterSource();
		
		//to check if the employee has applied leave for same date
		namedSqlParams.addValue("empid", empid);
		namedSqlParams.addValue("startdate", leaveDetails.getStartdate());
		namedSqlParams.addValue("enddate", leaveDetails.getEnddate());
		try {
		result = (Leave) namedParameterJdbcTemplate.queryForObject(leaveproperties.getCheckLeave(), namedSqlParams, new LeaveHistoryRowmapper());
		System.out.println(result);
		value="Duplicate";
		
		}
		catch(EmptyResultDataAccessException e){
			namedSqlParams.addValue("reason", leaveDetails.getReason());
			insert = namedParameterJdbcTemplate.update(leaveproperties.getInsertLeave(), namedSqlParams);
			if(insert == 1) {
				value="Success";
			}
			else {
			value="Fail";
		}
		}
		return value;
		
	}
		

	@Override
	public List<Leave> pendingLeave() {
		// TODO Auto-generated method stub
		namedSqlParams=new MapSqlParameterSource();
		@SuppressWarnings("unchecked")
		List<Leave> pendingLeaves = namedParameterJdbcTemplate.query(leaveproperties.getFetchall(), new LeaveRowmapper());
		return pendingLeaves;
	}

	@Override
	public List<Leave> leaveHistory(int empid) {
		// TODO Auto-generated method stub
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("empid", empid);	
		List<Leave> leaveHistory = namedParameterJdbcTemplate.query(leaveproperties.getFetchallLeaveHistory(), namedSqlParams, new LeaveHistoryRowmapper());
		return leaveHistory;
	}

	@Override
	public String acceptLeave(Leave leave, int empid) {
		// TODO Auto-generated method stub
		int result =0;
		namedSqlParams =new MapSqlParameterSource();
	    namedSqlParams.addValue("startdate", leave.getStartdate());
	    namedSqlParams.addValue("enddate", leave.getEnddate());
		namedSqlParams.addValue("empid", empid);
		try {
		result=namedParameterJdbcTemplate.update(leaveproperties.getAccept(),namedSqlParams);
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
	public String rejectLeave(Leave leave, int empid) {
		// TODO Auto-generated method stub
		int result =0;
		namedSqlParams =new MapSqlParameterSource();
	    namedSqlParams.addValue("startdate", leave.getStartdate());
	    namedSqlParams.addValue("enddate", leave.getEnddate());
		namedSqlParams.addValue("empid", empid);
		try {
		result=namedParameterJdbcTemplate.update(leaveproperties.getReject(),namedSqlParams);
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
	public String deleteLeave(int id) {
		// TODO Auto-generated method stub
		int result =0;
		namedSqlParams =new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		try {
		result=namedParameterJdbcTemplate.update(leaveproperties.getDelete(),namedSqlParams);
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
