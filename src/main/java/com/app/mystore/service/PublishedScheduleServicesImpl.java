package com.app.mystore.service;

import com.app.mystore.dao.PublishscheduleDaoImpl;
import com.app.mystore.dto.EmployeeSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.ArrayList;
/*
*Author : Parth Panchal
*B00845025
* PublishedScheduleServicesImpl service can record the schedule after receiving the confirm
* request from the manager employing publishscheduleDao.
* */
@Service("PublishScheduleService")
public class PublishedScheduleServicesImpl implements PublishedScheduleServices {
    @Autowired
    PublishscheduleDaoImpl publishscheduleDao;
    @Override
    public void saveSchedule(EmployeeSchedule employeeSchedule) {
        if(publishscheduleDao.isScheduleExist(employeeSchedule.getName())){
            System.out.println("Schedule Updated");
            publishscheduleDao.updateSchedule(employeeSchedule);
        }
        else {
            System.out.println("Schedule Inserted");
            publishscheduleDao.insertSchedule(employeeSchedule);
        }
    }

    @Override
    public ArrayList<EmployeeSchedule> retrieveSchedule() {
        return publishscheduleDao.retrieveSchedule();
    }
}
