package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.UserCourse;
import com.lti.service.NGOService;
import com.lti.service.UserCourseService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class UserCourseController {

	@Autowired
	private UserCourseService userCourseService;
	@Autowired
	private UserService userService;

	@Autowired
	private NGOService ngoService;
	
	@RequestMapping(path = "/userCourse.api")
	public String add(@RequestBody UserCourse uc) {
		userCourseService.addCourse(uc);
		return "{\"status\" : \"User Course  Details  Added Successfully!\"}";
	}
}
