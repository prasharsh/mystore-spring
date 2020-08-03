/**
 * Author: Khanjika Arora
 * Banner id: B00843319
 */


package com.app.mystore.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ManagerDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Manager;
import com.app.mystore.dto.User;
import com.app.mystore.utils.MystoreHelper;


@Service("managerControllerService")
public class ManagerControllerService {

	@Autowired
	ManagerDao managerDao;

	@Autowired
	UserDao userDao;

	@Autowired
	MystoreHelper helper;


	public List<Manager> viewEmployee() {
		List<Manager> employeeList = managerDao.employeeList();
		return employeeList;
	}


	public String DeleteEmployee(int id) {
		String result="";
		try {

			User user = userDao.getUseridById(id+"");
			result=managerDao.deleteEmployee(id);
			if(result.equals("success")) {
				String body="Sorry to inform that you are no longer a part of myStore and your profile is de-activated.";
				String subject="Associaction with mySore terminated";
				helper.sendEmail(user.getUsername(), body, subject);
			}
		} catch (Exception e) {
			return "failure";
		}

		return result;
	}





}
