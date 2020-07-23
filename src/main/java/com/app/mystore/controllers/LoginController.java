package com.app.mystore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.mystore.dto.User;
import com.app.mystore.service.LoginControllerService;
import com.google.gson.Gson;

@CrossOrigin
@RestController
@RequestMapping("/api/myStore")
public class LoginController {

	@Autowired
	private  LoginControllerService loginControllerService;

	Gson g = new Gson();

	@PostMapping(path ="/login", consumes = "application/json", produces = "application/json")
	public User login(@RequestBody User  loginUser){
		User user = null;
		try {
			user= (User)loginControllerService.login(loginUser);

		}
		catch (Exception e) {
			user = new User();
			user.setMessage(e.getLocalizedMessage());

		}

		if(user!=null) {

			return user;
		}
		return null;

	}

	@PostMapping("/register")
	public String register(@RequestBody User newUser){

		int record = 0;
		try {
			record =loginControllerService.register(newUser);
		}catch (Exception e) {
			return g.toJson(e.getMessage());
		}


		if(record> 0) {
			return g.toJson("success");
		}
		return g.toJson("failed");

	}

	@PutMapping("/updateProfile")
	public String updateProfile(@RequestBody User updateForUser){

		int record = 0;
		record =loginControllerService.updateUserProfiles(updateForUser);

		if(record> 0) {
			return "success";
		}
		return "failed";

	}

	@PutMapping("/changePassword")
	public String changePassword(@RequestBody User updatePasswordForUser){

		int record = 0;
		try {
			record =loginControllerService.updateUserPassword(updatePasswordForUser);
		}
		catch (Exception e) {
			return g.toJson(e.getMessage());
		}
		if(record> 0) {
			return "success";
		}
		return "failed";

	}

	@GetMapping("/fetchUserProfile/{id}")
	public User fetchUserProfile(
			@PathVariable("id") String id) {
		User user = null;
		try {
			user =	loginControllerService.getUserById(id);
		} catch (Exception e) {
			user = new User();
			user.setMessage(e.getMessage());
			return user;
		}
		return user;

	}


	@GetMapping("/resetPassword/{email}")
	public String resetPasswordToken(
			@PathVariable("email") String email) {
		String token = "";
		try {
			token = loginControllerService.getResetToken(email);
		} catch (Exception e) {
			return g.toJson(e.getMessage());
		}
		if(token==null || "".equals(token)) {
			token = "Email Id is not registered, please provide an registered email Id";
		}
		token="Please check your email for the token sent!!";
		return g.toJson(token);
	}

	@PutMapping("/updateRole/{userID}")
	public Boolean updateRole(@PathVariable int userID){
		int record = 0;
		try{
			record =loginControllerService.updateRole(userID);
		}
		catch (Exception e) {
			return false;
		}
		if(record> 0) {
			return true;
		}
		return false;
	}


}
