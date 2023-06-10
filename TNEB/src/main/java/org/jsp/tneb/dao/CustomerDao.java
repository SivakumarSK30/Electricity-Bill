package org.jsp.tneb.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.tneb.dto.Admin;
import org.jsp.tneb.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@Autowired
	EntityManager manager;
	
	public Customer login(long consumernumber) {
		String qry = "select u from Customer u where u.consumernumber=?1 ";

		Query q = manager.createQuery(qry);
		q.setParameter(1, consumernumber);
		try {
			return (Customer) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public Customer register(Customer user) {
		EntityTransaction t=manager.getTransaction();
		manager.persist(user);
		t.begin();
		t.commit();
		return user;
	}
	public Customer bill( int id) {
		String qry="select u from Customer u where u.consumernumber=?1";
		return manager.find(Customer.class, id);
	}
}
