package com.app.mystore.dao;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;
import com.app.mystore.dto.avail;

import java.util.ArrayList;

/**
 * Author: Parth Panchal
 * B00845025
 * AvailibilityDao is an interface confirming to AvailibilityDaoImpl.
 */
public interface AvailibilityDao {

	int saveAvail(ArrayList<Availability> availabilities,String UserId);
    int deleteUser(String User);
}
