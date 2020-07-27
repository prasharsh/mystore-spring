package com.app.mystore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ShiftSwapDao;
import com.app.mystore.dto.ShiftSwap;

@Service("ShiftSwapService")
public class ShiftSwapService {

	@Autowired
	private ShiftSwapDao dao;

	public int createSwapRequest(ShiftSwap swapRequest) throws Exception {

		int rows = dao.createSwapRequest(swapRequest);
		return rows;
	}

	public List<ShiftSwap> getSwapsById(String id) throws Exception {

		List<ShiftSwap> swaps = dao.getSwapsById(id);
		return swaps;
	}

	public int acceptShift(String sid, String uid) throws Exception{

		int rows = dao.acceptShift(sid, uid);
		return rows;
	}

	public int deleteShift(String sid) throws Exception{
		int rows = dao.deleteShift(sid);
		return rows;
	}

	public List<ShiftSwap> getShiftByUsername(String username) throws Exception {
		List<ShiftSwap> shift = dao.getShiftByUsername(username);
		return shift;
	}

	public int updateShiftComment(ShiftSwap shiftSwap) throws Exception {
		int rows = dao.updateShiftComment(shiftSwap);
		return rows;
		}

	public List<ShiftSwap> getOpenSwapsById(String id) throws Exception{
		List<ShiftSwap> swaps = null;
		
		swaps = dao.getOpenSwapsById(id);
		return swaps;
	}




}
