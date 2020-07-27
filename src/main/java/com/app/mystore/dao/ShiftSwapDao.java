package com.app.mystore.dao;

import java.util.List;

import com.app.mystore.dto.ShiftSwap;

public interface ShiftSwapDao {

	int createSwapRequest(ShiftSwap swapRequest) throws Exception;

	List<ShiftSwap> getSwapsById(String id) throws Exception;

	int acceptShift(String sid,String uid) throws Exception;

	int deleteShift(String sid) throws Exception;

	List<ShiftSwap>getShiftByUsername(String username) throws Exception;

	int updateShiftComment(ShiftSwap shiftSwap) throws Exception;

	List<ShiftSwap> getOpenSwapsById(String id) throws Exception;

	
}
