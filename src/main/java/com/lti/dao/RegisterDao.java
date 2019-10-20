package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.User;

@Repository
public class RegisterDao extends GenericDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	public User fetch(String email){
		String ql = "select u from User u where u.email=:tp";
		Query q = entityManager.createQuery(ql);
		q.setParameter("tp", email);
		return (User)q.getSingleResult();
	}
	
	public List<User> fecthAll(){
		String ql = "select u from User u";
		Query q = entityManager.createQuery(ql);
		return q.getResultList();
	}
	
}
