package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.AccountantDao;
import com.rest.java.entity.Accountant;
@Repository
public class AccountantDaoImpl implements AccountantDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Accountant addAccountant(Accountant accountant) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(accountant);
		tx.commit();
		session.close();
		return accountant;
	}

	@Override
	public Accountant updateAccountant(Accountant accountant) {
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(accountant);
		tx.commit();
		session.close();
		return accountant;
	}

	@Override
	public Accountant getOneAccountant(Integer acId) {
		Session session=sf.openSession();
		Accountant accountant =session.get(Accountant.class, acId);
		session.close();
		return accountant;
	}

	@Override
	public Accountant deleteAccountant(Integer acId) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Accountant accountant =session.get(Accountant.class, acId);
		if(accountant!=null) {
			accountant.setAcId(acId);
			session.delete(accountant);
		}
		tx.commit();
		session.close();
		return accountant;
	}

	@Override
	public List<Accountant> getAllAccountant() {
		Session session=sf.openSession();
		String getAll="FROM Accountant";
		Query query=session.createQuery(getAll);
		return query.list();
	}

}
