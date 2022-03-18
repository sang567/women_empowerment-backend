package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.lang.Double;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.NGO;
import com.lti.entity.ResponseDTO;
import com.lti.entity.User;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/user.api")
	public String add(@RequestBody User user) {
		userService.add(user);
		return "{\"status\" : \"User Record  Added Successfully!\"}";
	}
	@CrossOrigin
	@RequestMapping(path = "/userlogin.api")
	public String verifyUser(@RequestBody User login) {
		User user = userService.verifyUser(login);
		if (user != null) {
			return "{\"status\" : \"" + user.getName() + " you are logged in  Successfully!\"}";
		} else {
			return "{\"status\" : \"Sorry Your Details are incorrect!\"}";
		}
	}

	@CrossOrigin
	@RequestMapping(path = "/userVerify.api")
	public ResponseDTO verify(@RequestBody User login) {
		ResponseDTO responseDTO = userService.confirmLogin(login);
		return responseDTO;
	}
}