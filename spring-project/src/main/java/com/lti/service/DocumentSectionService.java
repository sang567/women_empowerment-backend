package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.DocumentSectionDao;
import com.lti.entity.DocumentSection;

@Component
public class DocumentSectionService {

	@Autowired
	private DocumentSectionDao documentSectionDao;

	@Transactional
	public void add(DocumentSection ds) {
		documentSectionDao.addDocumentSection(ds);
	}

	@Transactional
	public List<DocumentSection> fetchEach() {
		return documentSectionDao.fetchAll();

	}
}
