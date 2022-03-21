package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.NGO;
import com.lti.entity.ResponseDTO;
import com.lti.service.NGOService;

@RestController
@CrossOrigin
public class NGOController {

	@Autowired
	private NGOService ngoService;

	@RequestMapping("/ngo.api")
	public String add(@RequestBody NGO ngo) {
		ngoService.add(ngo);
		return "{\"status\" : \"NGO Record Added Successfully!\"}";
	}
	@RequestMapping("/ngologin.api")
	public String verifyNgo(@RequestBody NGO login) {
		NGO ngo = ngoService.verifyNgo(login);
		if (ngo != null) {
			return "{\"status\" : \"" + ngo.getName() + " you are logged in  Successfully!\"}";
		} else {
			return "{\"status\" : \"Sorry Your Details are incorrect!\"}";
		}
	}
	@RequestMapping("/ngoVerify.api")
	public ResponseDTO verify(@RequestBody NGO ngo) {

		ResponseDTO responseDTO = ngoService.confirmLogin(ngo);
		return responseDTO;

	}
}
