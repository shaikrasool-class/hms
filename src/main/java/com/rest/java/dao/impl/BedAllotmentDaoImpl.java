package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.BedAllotmentDao;
import com.rest.java.entity.BedAllotment;

@Repository
public class BedAllotmentDaoImpl implements BedAllotmentDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public BedAllotment createBedAllotment(BedAllotment bedAllotment) {
		Session session= sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bedAllotment);
		tx.commit();
		session.close();
		return bedAllotment;
	}

	@Override
	public BedAllotment upBedAllotment(BedAllotment bedAllotment) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(bedAllotment);
		tx.commit();
		session.close();
		return bedAllotment;
	}

	@Override
	public BedAllotment getBedAllotment(Integer bedId) {
		Session session=sf.openSession();
		BedAllotment bedAllotment=session.get(BedAllotment.class, bedId);
		session.close();
		return bedAllotment;
	}

	@Override
	public BedAllotment deBedAllotment(Integer bedId) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		BedAllotment bed=session.get(BedAllotment.class, bedId);
		if(bed!=null) {
			bed.setBedId(bedId);
			session.delete(bed);
		}
		tx.commit();
		session.close();
		return bed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BedAllotment> getAllBedAllotments() {
		Session session=sf.openSession();
		String AllBeds="From bed_allotment";
		Query query=session.createQuery(AllBeds);
		return query.list();
	}

}
