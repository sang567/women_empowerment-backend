package com.lti.dao;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.User;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserDao extends GenericDao {
	public void addUser(User user) {
		entityManager.persist(user);
	}
	@Transactional
	public User fetchUser(int id) {
		return entityManager.find(User.class, id);

	}
	@Transactional
	public User fetchUser(User login) {
		Query query = entityManager.createQuery(
				"Select user from User as user where user.username=:username and user.password=:password ");
		query.setParameter("username", login.getUsername());
		query.setParameter("password", login.getPassword());
		return (User) query.getSingleResult();
	}
	@Transactional
	public List<User> fetchAll() {
		Query q = entityManager.createQuery("select obj from User as obj");
		return q.getResultList();
	}

}
	
	

