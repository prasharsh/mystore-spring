package com.app.mystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.User;

@Service("loginControllerService")
public class LoginControllerService {

	@Autowired
	public UserDao userDao;


	public User login(User loginUser) {		

		return   userDao.loadUserByUsername(loginUser);
	}

	
}
