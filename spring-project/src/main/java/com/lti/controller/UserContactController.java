package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.UserContactDetails;
import com.lti.service.UserContactService;

@RestController
@CrossOrigin
public class UserContactController {

	@Autowired
	private UserContactService userContactService;

	@RequestMapping("/userContact.api")
	public String add(@RequestBody UserContactDetails ucd) {
		userContactService.add(ucd);
		return "{\"status\" : \"User Contact  Details  Added Successfully!\"}";
	}
}
