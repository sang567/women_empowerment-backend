package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.CourseDao;
import com.lti.entity.TrainingCourse;

@Component
public class CourseService {

	@Autowired
	private CourseDao courseDao;

	@Transactional
	public void add(TrainingCourse tc) {
		courseDao.addCourse(tc);
	}

	@Transactional
	public TrainingCourse fetch(int id) {
		return courseDao.fetchCourse(id);
	}

	@Transactional
	public List<TrainingCourse> fetchEach() {
		return courseDao.fetchAll();

	}
}
