package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.UserDao;
import com.lti.entity.ResponseDTO;
import com.lti.entity.ResponseType;
import com.lti.entity.User;

@Component
public class UserService {

	@Autowired
	private UserDao userdao;

	@Transactional
	public void add(User user) {
		userdao.addUser(user);
	}

	public User fetch(int id) {
		return userdao.fetchUser(id);
	}

	@Transactional
	public User verifyUser(User login) {
		String username = login.getUsername();
		
		String password = login.getPassword();
		boolean flag = false;
		List<User> list = userdao.fetchAll();
		for (User x : list) {
			System.out.println(x.getUsername());
			if (username.equals(x.getUsername()) && password.equals(x.getPassword()))
				return x;
		}
		return null;
	}

	@Transactional

	public ResponseDTO confirmLogin(User login) {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			User usr = userdao.fetchUser(login);
			if (usr.getUsername().equals(login.getUsername()) && usr.getPassword().equals(login.getPassword())) {
				responseDTO.setResponseType(ResponseType.VERIFIED);
				responseDTO.setUsername(usr.getUsername());
				System.out.println("inside if");
				System.out.println(responseDTO.getUsername());
				return responseDTO;
			}

			responseDTO.setResponseType(ResponseType.NOTVERIFIED);
			return responseDTO;
		} catch (Exception e) {
			e.printStackTrace();
			responseDTO.setResponseType(ResponseType.ERROR);
			return responseDTO;
		}
	}

	
	public List<User> fetchEach() {
		return userdao.fetchAll();

	}
}

