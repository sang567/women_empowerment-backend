package com.lti.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.TrainingCourse;

@Component
public class CourseDao extends GenericDao{

	
	public void addCourse(TrainingCourse tc) {
		entityManager.persist(tc);
	}
	
	public TrainingCourse fetchCourse(int id) {
		return entityManager.find(TrainingCourse.class, id);
	}
	
	@Transactional
	public List<TrainingCourse> fetchAll() {
		Query q = entityManager.createQuery("select obj from TrainingCourse as obj");
		return q.getResultList();

	}
}
