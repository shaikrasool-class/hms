package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.PharmacistDao;
import com.rest.java.entity.Pharmacist;

@Repository
public class PharmacistDaoImpl implements PharmacistDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public Pharmacist addPharmacist(Pharmacist pharmacist) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(pharmacist);
		tx.commit();
		session.close();
		return pharmacist;
	}

	@Override
	public Pharmacist updatePharmacist(Pharmacist pharmacist) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(pharmacist);
		tx.commit();
		session.close();
		return pharmacist;
	}

	@Override
	public Pharmacist getOnePharmacist(Integer phId) {
		Session session=sf.openSession();
		Pharmacist pharmacist=session.get(Pharmacist.class, phId);
		session.close();
		return pharmacist;
	}

	@Override
	public Pharmacist deletePharmacist(Integer phId) {
			Session session=sf.openSession();
			Transaction tx=session.beginTransaction();
			Pharmacist pharmacist=session.get(Pharmacist.class, phId);
			if(pharmacist!=null) {
				pharmacist.setPhId(phId);
				session.delete(pharmacist);
			}
			tx.commit();
			session.close();
		
		return pharmacist;
	}

	@Override
	public List<Pharmacist> getPharmacists() {
		Session session =sf.openSession();
		String getAll="FROM Pharmacist";
		Query query=session.createQuery(getAll);
		return query.list();
	}

}
