package com.app.mystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.StoreDetailsDao;
import com.app.mystore.dto.StoreDetails;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsService connects the controller to the doa class.
 */
@Service("storeDetailsService")
public class StoreDetailsService {
	
	@Autowired
	private StoreDetailsDao storeDetailsDao;

	public void updateDetails(StoreDetails details) throws Exception {
		storeDetailsDao.updateStoreDetails(details);
	}
	
	public StoreDetails getDetails() throws Exception {
		return storeDetailsDao.getDetails();
	}
}
