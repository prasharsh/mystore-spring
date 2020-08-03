package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.Manager;

public interface ManagerDao {

	public List<Manager> employeeList();

	public String deleteEmployee(int id);

}
