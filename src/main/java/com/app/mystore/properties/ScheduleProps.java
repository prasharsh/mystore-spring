package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/schedule_sql.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="schedule")
public class ScheduleProps {
    String queryuniquecrews;

    public String getQueryuniquecrews() {
        return queryuniquecrews;
    }

    public void setQueryuniquecrews(String queryuniquecrews) {
        this.queryuniquecrews = queryuniquecrews;
    }

    public String getShiftmappings() {
        return shiftmappings;
    }

    public void setShiftmappings(String shiftmappings) {
        this.shiftmappings = shiftmappings;
    }

    String shiftmappings;


}
