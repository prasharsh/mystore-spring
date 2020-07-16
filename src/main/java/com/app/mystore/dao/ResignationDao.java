package com.app.mystore.dao;
import java.util.List; 

import com.app.mystore.dto.Resignation;

public interface ResignationDao {
	
	
	public int apply(Resignation resign);
	public Resignation ResignationDetails(int rid);
	public int DeleteResignation(int rid);
	public List<Resignation> GetAllResignation();
	


}
