package org.jsp.tneb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.tneb.dto.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	EntityManager manager;
	
	public Admin login( long phone, String password ) {
		String qry = "select u from Admin u where u.phone=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (Admin) q.getSingleResult();
		} catch (NoResultException e) {
		}
		return null;
	}
	
	public Admin register(Admin admin) {
		EntityTransaction t=manager.getTransaction();
		manager.persist(admin);
		t.begin();
		t.commit();
		return admin;
	}
}
