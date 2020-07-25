package com.app.mystore.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql/publish_schedule.properties")
@EnableConfigurationProperties
@ConfigurationProperties(prefix="publish")
public class PublishSchedule {
    String insert;

    public String getUniquescheduleexist() {
        return uniquescheduleexist;
    }

    public void setUniquescheduleexist(String uniquescheduleexist) {
        this.uniquescheduleexist = uniquescheduleexist;
    }

    String uniquescheduleexist;





    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    String update;
    String select;
}
