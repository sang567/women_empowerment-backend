package com.lti.dao;

import java.util.List;


import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.UserCourse;
@Component
public class UserCourseDao extends GenericDao{
	@Transactional
	public void  add(UserCourse uc){
		entityManager.persist(uc);
	}
	@Transactional
	public List<UserCourse>fetchAll(){
		
			Query q = entityManager.createQuery("select obj from UserCourse as obj");
			return q.getResultList();
		
	}
	
	

}