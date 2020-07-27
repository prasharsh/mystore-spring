package com.app.mystore.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author: Prashant kumar
 * B00847456
 * UserDaoImpl is the dao implementation 
 * to interact with the data base layer for crud operations
 */

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.app.mystore.dto.ShiftSwap;
import com.app.mystore.dto.User;
import com.app.mystore.properties.ShiftSwapProperties;
import com.app.mystore.rowmapper.ShiftSwapRowMapper;

@Repository
@Configuration
public class ShiftSwapDaoImpl extends JdbcDaoSupport implements ShiftSwapDao {

	@Autowired
	private DataSource datasource;

	@Autowired
	private UserDao dao; 

	@Autowired
	public  ShiftSwapProperties properties;

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
	public int createSwapRequest(ShiftSwap swapRequest) throws Exception {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		// :swapDate , :shiftType , :swapComments , :swapRequestor , :swapStatus , :swappedWith
		namedSqlParams.addValue("swapDate", swapRequest.getSwapDate());
		namedSqlParams.addValue("shiftType", swapRequest.getShiftType());
		namedSqlParams.addValue("swapComments", swapRequest.getSwapComments());
		namedSqlParams.addValue("swapRequestor", swapRequest.getSwapRequestor());
		namedSqlParams.addValue("swapStatus", "ACTIVE");
		namedSqlParams.addValue("swappedWith", " ");

		try {
			rows = namedParameterJdbcTemplate.update(properties.getCreateSwapRequest(), namedSqlParams);	
		} 
		catch (Exception e) {
			throw new Exception("Error in DB, please check with the support team.");
		}
		return rows;

	}

	@Override
	public List<ShiftSwap> getSwapsById(String id) throws Exception {

		List<ShiftSwap> swaps = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		try {
			swaps=(List<ShiftSwap>) namedParameterJdbcTemplate.query(
					properties.getFetchSwapsByUid(), namedSqlParams, new ShiftSwapRowMapper());
		} catch (DataAccessException e) {

			throw new Exception("Database error, please contact support team");

		}

		return swaps;
	}

	@Override
	public int acceptShift(String sid, String uid) throws Exception {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("sid", sid);
		namedSqlParams.addValue("uid", sid);
		try {
			rows = namedParameterJdbcTemplate.update(properties.getAcceptSwap(), namedSqlParams);	
		} 
		catch (Exception e) {
			throw new Exception("Error in DB, please check with the support team.");
		}
		return rows;
	}

	@Override
	public int deleteShift(String sid) throws Exception {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("sid", sid);
		try {
			rows = namedParameterJdbcTemplate.update(properties.getDeleteSwap(), namedSqlParams);	
		} 
		catch (Exception e) {
			throw new Exception("Error in DB, please check with the support team.");
		}
		return rows;
	}

	@Override
	public List<ShiftSwap>  getShiftByUsername(String username) throws Exception {

		//	ArrayList<EmployeeSchedule> employeeSchedules = new ArrayList<>();

		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("username", username);

		List<ShiftSwap> shiftList = new ArrayList<ShiftSwap>();
		try {
			List<Map<String, Object>> list= namedParameterJdbcTemplate.queryForList(
					properties.getShiftDefinedByUserName(), namedSqlParams);
			if (list!= null) {

				for (Map row : list) {
					ShiftSwap monday = new ShiftSwap();
					monday.setSwapDate("Monday");
					monday.setShiftType((String)row.get("monday"));

					ShiftSwap tuesday = new ShiftSwap();
					tuesday.setSwapDate("Tuesday");
					tuesday.setShiftType((String)row.get("tuesday"));

					ShiftSwap wednesday = new ShiftSwap();
					wednesday.setSwapDate("Wednesday");
					wednesday.setShiftType((String)row.get("wednesday"));

					ShiftSwap thursday = new ShiftSwap();
					thursday.setSwapDate("Thursday");
					thursday.setShiftType((String)row.get("thursday"));
					ShiftSwap friday = new ShiftSwap();
					friday.setSwapDate("Friday");
					friday.setShiftType((String)row.get("friday"));


					ShiftSwap saturday = new ShiftSwap();
					saturday.setSwapDate("Saturday");
					saturday.setShiftType((String)row.get("saturday"));

					ShiftSwap sunday = new ShiftSwap();
					sunday.setSwapDate("Sunday");
					sunday.setShiftType((String)row.get("sunday"));


					shiftList.add(monday);
					shiftList.add(tuesday);
					shiftList.add(wednesday);
					shiftList.add(thursday);
					shiftList.add(friday);
					shiftList.add(saturday);
					shiftList.add(sunday);

				}
			}

		} catch (DataAccessException e) {

			throw new Exception("Database error, please contact support team");

		}

		return shiftList;

	}

	@Override
	public int updateShiftComment(ShiftSwap shiftSwap) throws Exception {
		int rows =0;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("sid", shiftSwap.getSwapId());
		namedSqlParams.addValue("shiftComment", shiftSwap.getSwapComments());
		try {
			rows = namedParameterJdbcTemplate.update(properties.getUpdateSwapComment(), namedSqlParams);	
		} 
		catch (Exception e) {
			throw new Exception("Error in DB, please check with the support team.");
		}
		return rows;

	}

	@Override
	public List<ShiftSwap> getOpenSwapsById(String id) throws Exception {

		User user = dao.getUseridById(id);



		List<ShiftSwap> swaps = null;
		namedSqlParams=new MapSqlParameterSource();
		namedSqlParams.addValue("id", id);
		try {
			List<ShiftSwap> shiftList = getShiftByUsername(user.getUsername());
			swaps=(List<ShiftSwap>) namedParameterJdbcTemplate.query(
					"SELECT * FROM mystore.shift_swap where swapRequestor not in ("+id+") and `swapStatus` = 'ACTIVE'", new ShiftSwapRowMapper());

			for (ShiftSwap openShift : swaps) {
				boolean isAssigned = false;
				for (ShiftSwap shift : shiftList) {
					if(!shift.getShiftType().isEmpty() && !shift.getShiftType().isEmpty() && (shift.getSwapDate().equals(openShift.getSwapDate()) )) {
						isAssigned = true;
					}
				}
				if(!isAssigned) {
					System.out.println(openShift.toString());
				}

			}
		} catch (DataAccessException e) {

			throw new Exception("Database error, please contact support team");

		}

		return swaps;

	}

}
