package com.lti.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.DocumentSection;

@Component
public class DocumentSectionDao extends GenericDao{

	@Transactional
	public void addDocumentSection(DocumentSection ds) {
		entityManager.persist(ds);
	}

	
	
}
