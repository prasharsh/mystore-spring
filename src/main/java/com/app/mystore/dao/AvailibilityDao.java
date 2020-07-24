package com.app.mystore.dao;

import com.app.mystore.dto.Availability;
import com.app.mystore.dto.ResetPassword;
import com.app.mystore.dto.User;

public interface AvailibilityDao {

	int saveAvail(Availability avail);
    int deleteUser(String User);
}
