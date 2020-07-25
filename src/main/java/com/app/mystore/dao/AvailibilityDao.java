package com.app.mystore.dao;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
/**
 * Author: Parth Panchal
 * B00845025
 * AvailibilityDao is an interface confirming to AvailibilityDaoImpl.
 */
public interface AvailibilityDao {

	int saveAvail(Availability avail);
    int deleteUser(String User);
}
