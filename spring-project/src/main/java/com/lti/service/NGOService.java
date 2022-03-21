package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.NGODao;
import com.lti.entity.NGO;
import com.lti.entity.ResponseDTO;
import com.lti.entity.ResponseType;

@Component
public class NGOService {

	@Autowired
	private NGODao ngoDao;

	@Transactional
	public void add(NGO ngo) {
		ngoDao.addNGO(ngo);
	}

	public NGO fetch(int id) {
		return ngoDao.fetchNGO(id);
	}

	@Transactional
	public NGO verifyNgo(NGO login) {
		String username = login.getUsername();
		String password = login.getPassword();
		boolean flag = false;
		List<NGO> list = ngoDao.fetchAll();
		for (NGO ng : list) {
			if (username.equals(ng.getUsername()) && password.equals(ng.getPassword()))
				return ng;
		}
		return null;
	}

	@Transactional
	public ResponseDTO confirmLogin(NGO ngo) {
		ResponseDTO responseDTO = new ResponseDTO();

		try {
			List<NGO> usr = ngoDao.fetchAll();
			for (NGO u : usr) {
				if (u.getUsername().equals(ngo.getUsername()) && u.getPassword().equals(ngo.getPassword())) {
					responseDTO.setResponseType(ResponseType.VERIFIED);
					responseDTO.setUsername(u.getUsername());
					return responseDTO;
				}
			}
			responseDTO.setResponseType(ResponseType.NOTVERIFIED);
			return responseDTO;
		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setResponseType(ResponseType.ERROR);
			return responseDTO;
		}
	}


	public List<NGO> fetchEach() {
		return ngoDao.fetchAll();

	}
}
