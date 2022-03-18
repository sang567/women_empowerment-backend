package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.dao.UserCourseDao;
import com.lti.entity.UserCourse;

@Component
public class UserCourseService {
	@Autowired
	private UserCourseDao userCoursedao;
	
	@Transactional
	public void addCourse(UserCourse ucd) {
		userCoursedao.add(ucd);
	}
	
	@Transactional
	public List<UserCourse> fetchEach() {
		return userCoursedao.fetchAll();

	}

}


