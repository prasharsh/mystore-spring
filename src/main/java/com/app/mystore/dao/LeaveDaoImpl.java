package com.app.mystore.dao;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.app.mystore.dto.Leave;
import com.app.mystore.dto.User;
import com.app.mystore.properties.LeaveProperties;
import com.app.mystore.rowmapper.LeaveRowmapper;
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
	public String enterLeaveData(Leave leaveDetails) {
		// TODO Auto-generated method stub
		int result = 0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("empid", leaveDetails.getEmpid());
		namedSqlParams.addValue("startdate", leaveDetails.getStartdate());
		namedSqlParams.addValue("enddate", leaveDetails.getEnddate());
		namedSqlParams.addValue("reason", leaveDetails.getReason());
		result = namedParameterJdbcTemplate.update(leaveproperties.getInsertLeave(), namedSqlParams);
		
		if(result == 1){
			return "Success";
		}
		else
		{
			return "Failure";
		}
	}

	@Override
	public List<Leave> pendingLeave() {
		// TODO Auto-generated method stub
		namedSqlParams=new MapSqlParameterSource();
		@SuppressWarnings("unchecked")
		List<Leave> pendingLeaves = namedParameterJdbcTemplate.query(leaveproperties.getFetchall(), new LeaveRowmapper());
		return pendingLeaves;
	}

}
