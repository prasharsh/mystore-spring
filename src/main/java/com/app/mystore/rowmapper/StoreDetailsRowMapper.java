package com.app.mystore.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.mystore.dto.StoreDetails;

/**
 * Author: Suraj Kandikonda
 * B00854472
 * StoreDetailsRowMapper is used to map the values returned from the database to create a new StoreDetails object
 */
public class StoreDetailsRowMapper  implements RowMapper{

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		StoreDetails storeDetails=new StoreDetails();
		storeDetails.setAddress(rs.getString("address"));
		storeDetails.setId(rs.getInt("id"));
		storeDetails.setStoreEmail(rs.getString("store_email"));
		storeDetails.setStoreName(rs.getString("store_name"));
		return storeDetails;
	}

}
