package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.dto.RegisterStatus;
import com.lti.entity.Customer;
import com.lti.exception.CustomerServiceException;
import com.lti.service.DocumentSectionService;

public class DocumentSectionController {

	@Autowired
	private DocumentSectionService documentSectionService;
	@RequestMapping("/register.api")
	public String add(@RequestBody  customer) {
		try {
			int id=customerService.register(customer);
			RegisterStatus status=new RegisterStatus();
			status.setStatus(true);
			status.setRegisteredCustomerId(id);
			
			return status;
		}
		catch(CustomerServiceException e) {
			
			RegisterStatus status=new RegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			
			return status;
		}
}
