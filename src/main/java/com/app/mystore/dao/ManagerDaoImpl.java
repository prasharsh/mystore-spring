package com.app.mystore.dao;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.Leave;
import com.app.mystore.dto.Manager;
import com.app.mystore.properties.LeaveProperties;
import com.app.mystore.properties.ManagerProperties;
import com.app.mystore.rowmapper.ManagerRowmapper;

@Repository
@Configuration
public class ManagerDaoImpl extends JdbcDaoSupport implements ManagerDao{
	
	@Autowired
	private DataSource datasource;
	
	@Autowired
	public  ManagerProperties managerproperties;
	
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
	public List<Manager> employeeList() {
		// TODO Auto-generated method stub
		namedSqlParams=new MapSqlParameterSource();
		List<Manager> managerList = namedParameterJdbcTemplate.query(managerproperties.getEmployeeList(), namedSqlParams, new ManagerRowmapper());
		return managerList;
	}

	@Override
	public String deleteEmployee(int id) {
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		
		try {

			namedParameterJdbcTemplate.update("UPDATE `mystore`.`leave` SET status = 'Inactive' WHERE empid =:id", namedSqlParams);	
			namedParameterJdbcTemplate.update("UPDATE `mystore`.`resignation` SET `status` = 'Accepted' WHERE empid =:id and `status` not in ('REJECTED')", namedSqlParams);	
			namedParameterJdbcTemplate.update("UPDATE `mystore`.`user_profiles` SET `status` = 'INACTIVE' WHERE id =:id", namedSqlParams);	
		}catch (Exception e) {
			return "failure";
		}
		return "success";
	}

}
