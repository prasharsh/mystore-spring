package com.app.mystore.dao;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ShiftDetails;
import com.app.mystore.dto.avail;
import com.app.mystore.properties.ScheduleProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.*;

/**
 * Author: Parth Panchal
 * B00845025
 * ScheduleDaoImpl retrieves the shift details and all availabilities from database to transform into specific datamodels
 * avail and ShiftDetails.
 */

@Repository
@Configuration
public class ScheduleDaoImpl extends JdbcDaoSupport implements ScheduleDao {


    @Autowired
    private DataSource datasource;

    @Autowired
    private ScheduleProps scheduleProps;

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
    public int crewTally() {
        int result=0;
        Availability availability = null;
        namedSqlParams = new MapSqlParameterSource();
        try {

            List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(scheduleProps.getQueryuniquecrews(),namedSqlParams);

            if (list!= null) {
                System.out.println(list.size());
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

    @Override
    public ArrayList<avail> getAllAvailibility() {
        namedSqlParams = new MapSqlParameterSource();
        ArrayList<avail> availAllCrews = new ArrayList<>();
        ArrayList<Availability> allAvail = new ArrayList<>();
        HashMap<String,avail> map = new HashMap<>();
        try {

            List<Map<String, Object>> list = namedParameterJdbcTemplate.queryForList(scheduleProps.getGetAllAvailibility(), namedSqlParams);

            if (list != null) {
                System.out.println(list.size());

                for (Map row : list) {

                    Availability record = new Availability();
                    String userId = (String) row.get("UserID");
                    avail recordExisted = (avail) map.get(userId);
                    System.out.println(userId);
                    record.setUserId((String) row.get("UserID"));
                    record.setEnd((String) row.get("END"));
                    record.setStart((String) row.get("START"));
                    record.setDay((String) row.get("DAY"));
                    System.out.println((String) row.get("DAY"));
                    //allAvail.add(record);

                    if (null == recordExisted) {
                        avail newRecord = new avail();
                        newRecord.setUsername(userId);
                        newRecord.setWeekDays(record);
                        map.put(userId, newRecord);
                    } else {
                        recordExisted.setWeekDays(record);
                        map.put(userId, recordExisted);
                    }
                }
            }
            System.out.println("Hashmap : " + map);
            Set<String> keys = map.keySet();
            for (String key:keys){
                avail rec = map.get(key);
                availAllCrews.add(rec);
            }
            for (avail a:availAllCrews){
                System.out.println(a.getUsername());
                System.out.println(a.getThrusStart());
            }
        }

        catch(DataAccessException e)
        {

            System.out.println(e.getMessage());
        }
        return availAllCrews;
    }

    @Override
    public ArrayList<ShiftDetails> getShiftDetails() {
        // SELECT * FROM mystore.SHIFT_MAPPING
        int result=0;
        ArrayList<ShiftDetails> shiftRecords = new ArrayList<>();
        namedSqlParams = new MapSqlParameterSource();
        try {

            List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(scheduleProps.getShiftmappings(),namedSqlParams);

            if (list!= null) {
                System.out.println("List Shift  ::::"+list.size());
                for (Map row : list) {
                   ShiftDetails shiftDetails = new ShiftDetails ();
                    shiftDetails.setStart((String)row.get("START"));
                    System.out.println(row.get("START"));
                    shiftDetails.setEnd((String)row.get("END"));
                    shiftDetails.setNumber((Integer)row.get("SHIFT_ID"));
                    shiftRecords.add(shiftDetails);
                }

            }
            else
                result =0;
        }

        catch(DataAccessException e)
        {

            System.out.println(e.getMessage());
        }
                return shiftRecords;

    }


}
