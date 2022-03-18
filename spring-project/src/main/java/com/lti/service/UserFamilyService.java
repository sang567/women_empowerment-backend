package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.UserFamilyDao;
import com.lti.entity.UserFamilyDetails;
 
@Component
public class UserFamilyService {
	
	@Autowired
	private UserFamilyDao userFamilydao;

	@Transactional
	public void add(UserFamilyDetails ufd) {
		userFamilydao.addUserFamilyDetails(ufd);
	}
	
	@Transactional
	public List<UserFamilyDetails> fetchEach() {
		return userFamilydao.fetchAll();

	}

}



