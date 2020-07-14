package com.app.mystore.dao;

import com.app.mystore.dto.User;

public interface UserDao {

	public User loadUserByUsername(User loginUser);
}
