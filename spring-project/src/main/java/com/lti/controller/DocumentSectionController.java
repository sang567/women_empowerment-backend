package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.DocumentSection;

import com.lti.service.DocumentSectionService;

@RestController
@CrossOrigin
public class DocumentSectionController {

	@Autowired
	private DocumentSectionService documentSectionService;
	
	@RequestMapping("/document.api")
	public String add(@RequestBody DocumentSection ds) {
		documentSectionService.add(ds);
		return "{\"status\" : \"Document Section Record Added Successfully!\"}";
	}
}
