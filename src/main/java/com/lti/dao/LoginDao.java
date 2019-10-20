package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.User;

@Repository
public class LoginDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public User fetchUser(String email){
		String ql = "select u from User u where u.userEmail=:tp";
		Query q = entityManager.createQuery(ql);
		q.setParameter("tp", email);
		return (User)q.getSingleResult();
	}
}
