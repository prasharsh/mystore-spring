package com.app.mystore.controllers;


import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.mystore.dto.Resignation;
import com.app.mystore.service.ResignationControllerService;

@CrossOrigin
@RestController
@RequestMapping("/api/mystore/requests")

public class ActionOnResignation
{
	@Autowired
	private  ResignationControllerService resignationControllerService;
	
	@RequestMapping("/resignation")
	public List<Resignation> viewResignations(){
		List <Resignation> list=(List<Resignation>) resignationControllerService.viewResignation();
				return list;
		
	}
	@RequestMapping("/resignation/accept/{empid}")
	public String acceptResignation(@PathVariable int empid)
	{
		String result= resignationControllerService.acceptResignation(empid);
		return result;
		
	}
	
};

