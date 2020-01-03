package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.MedicineSaleDao;
import com.rest.java.entity.MedicineSale;
@Repository
public class MedicineSaleDaoImpl implements MedicineSaleDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public MedicineSale createMedicineSale(MedicineSale medicine) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(medicine);
		tx.commit();
		session.close();
		return medicine;
	}

	@Override
	public MedicineSale updMedicineSale(MedicineSale medicine) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(medicine);
		tx.commit();
		session.close();
		return medicine;
	}

	@Override
	public MedicineSale getMedicineSale(Integer med_Id) {
		Session session=sf.openSession();
		MedicineSale medicine=session.get(MedicineSale.class, med_Id);
		session.close();
		return medicine;
	}

	@Override
	public MedicineSale deleteMedicineSale(Integer med_Id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		MedicineSale medicine=session.get(MedicineSale.class, med_Id);
		if(medicine !=null) {
		medicine.setMed_Id(med_Id);
		session.delete(medicine);
		}
		tx.commit();
		session.close();
		return medicine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicineSale> getAllMedicineSalse() {
		Session session=sf.openSession();
		String getAllSales="FROM MedicineSale";
		Query query=session.createQuery(getAllSales);
		return query.list();
	}
	
	
}
