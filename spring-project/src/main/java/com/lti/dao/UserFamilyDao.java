package com.lti.dao;

import java.util.List;


import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.UserFamilyDetails;
@Component
public class UserFamilyDao extends GenericDao {
	
	@Transactional
	public void addUserFamilyDetails(UserFamilyDetails ufd) {
		entityManager.persist(ufd);
	}
	@Transactional
	public List<UserFamilyDetails> fetchAll() {
		Query q = entityManager.createQuery("select obj from UserFamilyDetails as obj");
		return q.getResultList();
	}

		
		
	}
	


