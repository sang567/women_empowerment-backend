package com.lti.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.UserContactDetails;

@Component
public class UserContactDao extends GenericDao{

	public void addUserContact(UserContactDetails ucd) {
		entityManager.persist(ucd);
	}

	@Transactional
	public List<UserContactDetails> fetchAll() {
		Query q = entityManager.createQuery("select obj from UserContactDetails as obj");
		return q.getResultList();
	}
}
