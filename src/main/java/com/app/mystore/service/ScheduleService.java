package com.app.mystore.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ResetPasswordDao;
import com.app.mystore.dao.ScheduleDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;

@Service("scheduleService")
public class ScheduleService {

	@Autowired
	public ScheduleDao dao;

	public int saveAvail(Availability avail) {
		int rows = dao.saveAvail(avail);
		return rows;
	}

	
}
