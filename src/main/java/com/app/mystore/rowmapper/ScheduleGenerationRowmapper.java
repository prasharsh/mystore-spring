package com.app.mystore.rowmapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.mystore.dto.Availability;
import org.springframework.jdbc.core.RowMapper;

public class ScheduleGenerationRowmapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

        //System.out.println(rs.getString("UserID"));
        Availability availability = new Availability();
        //String[] result = new String[7];
        //System.out.println("Length : "+rs.getString("userid").getClass());
        System.out.println(rs.getString("UserID").getClass());
        availability.setUserId(rs.getString("UserID"));
       // availability.setStart(rs.getString("DAY"));
       // availability.setStart(rs.getString("START"));
       // availability.setEnd(rs.getString("END"));
        return rs.getString("UserID");
    }
}
