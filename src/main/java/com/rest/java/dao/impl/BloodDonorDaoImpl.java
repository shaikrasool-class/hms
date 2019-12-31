package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.BloodDonorDao;
import com.rest.java.entity.BloodDonor;
@Repository
public class BloodDonorDaoImpl implements BloodDonorDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public BloodDonor addBloodDonor(BloodDonor bloodDonor) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bloodDonor);
		tx.commit();
		session.close();
		return bloodDonor;
	}

	@Override
	public BloodDonor updateBloodDonor(BloodDonor bloodDonor) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(bloodDonor);
		tx.commit();
		session.close();
		return bloodDonor;
	}

	@Override
	public BloodDonor getBloodDonorById(Integer donorId) {
		Session session=sf.openSession();
		BloodDonor donor=session.get(BloodDonor.class, donorId);
		session.close();
		return donor;
	}

	@Override
	public BloodDonor deleteBloodDonorById(Integer donorId) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		BloodDonor donor=session.get(BloodDonor.class, donorId);
		if(donor!=null) {
			donor.setDonorId(donorId);
			session.delete(donor);
		}
		tx.commit();
		session.close();
		return donor;
	}

	@Override
	public List<BloodDonor> getAllBloodDonors() {
		Session session=sf.openSession();
		String allDonors="FROM BloodDonor";
		Query query=session.createQuery(allDonors);
		return query.list();
	}

}
