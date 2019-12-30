package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.BedDao;
import com.rest.java.entity.Bed;

@Repository
public class BedDaoImpl implements BedDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Bed createBed(Bed bed) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bed);
		tx.commit();
		session.close();
		return bed;
	}

	@Override
	public Bed updateBed(Bed bed) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(bed);
		tx.commit();
		session.close();
		return bed;
	}

	@Override
	public Bed GetOneBedById(Integer bed_Id) {
		Session session=sf.openSession();
		Bed bed=session.get(Bed.class, bed_Id);
		session.close();
		return bed;
	}

	@Override
	public Bed deleteBed(Integer bed_Id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Bed bed=session.get(Bed.class, bed_Id);
		if(bed!=null) {
			bed.setBed_Id(bed_Id);
			session.delete(bed);
		}
		tx.commit();
		session.close();
		return bed;
	}

	@Override
	public List<Bed> getAllBeds() {
		Session session=sf.openSession();
		String allBeds="FROM Bed";
		Query query=session.createQuery(allBeds);
		return query.list();
	}

}
