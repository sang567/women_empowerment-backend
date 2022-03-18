package com.lti.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.NGO;

@Component
public class NGODao extends GenericDao{
	
	@Transactional
	public void addNGO(NGO ngo) {
		entityManager.persist(ngo);
	}

	@Transactional
	public NGO fetchNGO(int id) {
		return entityManager.find(NGO.class, id);
	}

	@Transactional
	public List<NGO> fetchAll() {
		Query q = entityManager.createQuery("select obj from NGO as obj");
		return q.getResultList();
	}
}
