package com.app.mystore.dao;

import com.app.mystore.dto.EmployeeSchedule;

import com.app.mystore.properties.PublishSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
@Configuration
public class PublishscheduleDaoImpl  extends JdbcDaoSupport implements PublishscheduleDao {
    @Autowired
    private DataSource datasource;

    @Autowired
    PublishSchedule publishSchedule;

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
    public int insertSchedule(EmployeeSchedule employeeSchedules) {
        namedSqlParams = new MapSqlParameterSource();
        namedSqlParams.addValue("name",employeeSchedules.getName());
        namedSqlParams.addValue("monday",employeeSchedules.getMon());
        namedSqlParams.addValue("tuesday",employeeSchedules.getTues());
        namedSqlParams.addValue("wednesday",employeeSchedules.getWed());
        namedSqlParams.addValue("thursday",employeeSchedules.getTues());
        namedSqlParams.addValue("friday",employeeSchedules.getTues());
        namedSqlParams.addValue("saturday",employeeSchedules.getTues());
        namedSqlParams.addValue("sunday",employeeSchedules.getTues());
        int rowsUpdated = namedParameterJdbcTemplate.update(publishSchedule.getInsert(),namedSqlParams);
        System.out.println("Rows Inserted : "+rowsUpdated);
        return rowsUpdated;
    }

    @Override
    public int updateSchedule(EmployeeSchedule employeeSchedules) {
        namedSqlParams = new MapSqlParameterSource();
        System.out.println("E Name"+employeeSchedules.getName());
        namedSqlParams.addValue("name",employeeSchedules.getName());
        namedSqlParams.addValue("monday",employeeSchedules.getMon());
        namedSqlParams.addValue("tuesday",employeeSchedules.getTues());
        namedSqlParams.addValue("wednesday",employeeSchedules.getWed());
        namedSqlParams.addValue("thursday",employeeSchedules.getThrus());
        namedSqlParams.addValue("friday",employeeSchedules.getFri());
        namedSqlParams.addValue("saturday",employeeSchedules.getSat());
        namedSqlParams.addValue("sunday",employeeSchedules.getSun());
        int rowsUpdated = namedParameterJdbcTemplate.update(publishSchedule.getUpdate(),namedSqlParams);
        System.out.println("Rows Updated : "+rowsUpdated);
        return rowsUpdated;
    }

    @Override
    public boolean isScheduleExist(String UserId) {


        boolean returnFlag = false;
        namedSqlParams = new MapSqlParameterSource();
        namedSqlParams.addValue("name",UserId);
        try {

            List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(publishSchedule.getUniquescheduleexist(),namedSqlParams);
            System.out.println("Schedule size : "+list.size());
            if (list.size() > 0) {

                returnFlag = true;
            }

        }

        catch(DataAccessException e)
        {

            System.out.println(e.getMessage());
        }



        return returnFlag;
    }

    @Override
    public ArrayList<EmployeeSchedule> retrieveSchedule() {
        boolean returnFlag = false;
        namedSqlParams = new MapSqlParameterSource();
        ArrayList<EmployeeSchedule> employeeSchedules = new ArrayList<>();
        try {

            List<Map<String, Object>> list =  namedParameterJdbcTemplate.queryForList(publishSchedule.getSelect(),namedSqlParams);

            if (list!= null) {

                for (Map row : list) {
                    EmployeeSchedule employeeSchedule = new EmployeeSchedule();
                    System.out.println((String) row.get("name"));
                    employeeSchedule.setName((String) row.get("name"));
                    employeeSchedule.setMon((String) row.get("monday"));
                    employeeSchedule.setTues((String)row.get("tuesday"));
                    employeeSchedule.setWed((String)row.get("wednesday"));
                    employeeSchedule.setThrus((String)row.get("thursday"));
                    employeeSchedule.setFri((String)row.get("friday"));
                    employeeSchedule.setSat((String)row.get("saturday"));
                    employeeSchedule.setSat((String)row.get("sunday"));
                    employeeSchedules.add(employeeSchedule);

                }

            }

        }

        catch(DataAccessException e)
        {

            System.out.println(e.getMessage());
        }



        return employeeSchedules;
    }
}
