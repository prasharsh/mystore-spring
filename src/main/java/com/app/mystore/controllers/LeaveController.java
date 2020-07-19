package com.app.mystore.controllers;
import com.app.mystore.dto.Leave;
import com.app.mystore.dto.User;
import com.app.mystore.service.LeaveControllerService;
import com.app.mystore.service.LoginControllerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/myStore/leave")
public class LeaveController {
	
	@Autowired
	private  LeaveControllerService leaveControllerService;
	
	@PostMapping("/apply")
	public @ResponseBody String applyLeave (@RequestBody Leave leaveDetails){
		
		String leaveAppliedResponse= leaveControllerService.applyLeave(leaveDetails);
		
		return leaveAppliedResponse;

	}
	
	@RequestMapping(value = "/viewLeaveRequest", method = RequestMethod.GET)
	@ResponseBody
	public List<Leave> viewLeaveRequest(){
		List <Leave> list=leaveControllerService.viewLeaveRequest();
		return list;

	}

}
