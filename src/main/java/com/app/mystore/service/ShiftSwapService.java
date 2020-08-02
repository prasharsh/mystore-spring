package com.app.mystore.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mystore.dao.ShiftSwapDao;
import com.app.mystore.dao.UserDao;
import com.app.mystore.dto.Notification;
import com.app.mystore.dto.ShiftSwap;
import com.app.mystore.dto.User;

@Service("ShiftSwapService")
public class ShiftSwapService {

	@Autowired
	private ShiftSwapDao dao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private NotificationService ns;

	public int createSwapRequest(ShiftSwap swapRequest) throws Exception {

		int rows = dao.createSwapRequest(swapRequest);
		return rows;
	}

	public List<ShiftSwap> getSwapsById(String id) throws Exception {

		List<ShiftSwap> swaps = dao.getSwapsById(id);
		return swaps;
	}

	public int acceptShift(ShiftSwap swap) throws Exception{
		//update schedule

		int swapWithSchedule = dao.updateSwapWithSchedule(swap);
	
		int requestorSchedule = dao.updateSwapRequestorSchedule(swap);
		int rows = dao.acceptShift(swap.getSwapId()+"", swap.getSwappedWith());
		
		Notification notification = new Notification();
		User swappedWith = userDao.getUseridById(swap.getSwappedWith());
		User swapReq = userDao.getUseridById(swap.getSwapRequestor());
		notification.setUserId(userDao.getManagerId());
		notification.setNotification(swappedWith.getFirstName()+" "+swappedWith.getLastName()+" has taken up "+swap.getSwapDate()+" "+swap.getShiftType()+" shift from "+ swapReq.getFirstName()+" "+swapReq.getLastName());
		notification.setNotificationType("Shift Notification");
		ns.createNotification(notification);	
	
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
