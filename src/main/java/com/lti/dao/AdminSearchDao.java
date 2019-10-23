package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.User;

@Repository
public class AdminSearchDao {

	@PersistenceContext
	public EntityManager entityManager;
	
	public List<User> searchUsers(String state){
		
		String ql = "select u from User u where u.userState=:tp";
		Query q = entityManager.createQuery(ql);
		q.setParameter("tp",state);
		
		return q.getResultList();
		
	}
}
