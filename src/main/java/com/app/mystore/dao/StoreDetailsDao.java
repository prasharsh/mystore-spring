package com.app.mystore.dao;

import com.app.mystore.dto.StoreDetails;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsDao is an interface for all the DB operations required
 * for the  StoreDetails
 */
public interface StoreDetailsDao {
	public void updateStoreDetails(StoreDetails details)throws Exception;
	public StoreDetails getDetails()throws Exception;
}
