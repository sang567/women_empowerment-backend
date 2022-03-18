package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.UserContactDao;
import com.lti.entity.UserContactDetails;

@Component
public class UserContactService {

	@Autowired
	private UserContactDao userContactDao;

	@Transactional
	public void add(UserContactDetails ucd) {
		userContactDao.addUserContact(ucd);
	}

	@Transactional
	public List<UserContactDetails> fetchEach() {
		return userContactDao.fetchAll();

	}
}
