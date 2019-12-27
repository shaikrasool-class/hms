package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.LaboratoristDao;
import com.rest.java.entity.Laboratorist;
@Repository
public class LaboratoristDaoImpl implements LaboratoristDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Laboratorist addLaboratorist(Laboratorist lab) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(lab);
		tx.commit();
		session.close();
		return lab;
	}

	@Override
	public Laboratorist updateLaboratorist(Laboratorist lab) {
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(lab);
		tx.commit();
		session.close();
		return lab;
	}

	@Override
	public Laboratorist getOneLaboratorist(Integer labId) {
		Session session=sf.openSession();
		Laboratorist laboratorist=session.get(Laboratorist.class, labId);
		session.close();
		return laboratorist;
	}

	@Override
	public Laboratorist deleteLaboratorist(Integer labId) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Laboratorist laboratorist=session.get(Laboratorist.class, labId);
		if(laboratorist!=null) {
			laboratorist.setLabId(labId);
			session.delete(laboratorist);
		}
		tx.commit();
		session.close();
		return laboratorist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Laboratorist> getAllLaboratorist() {
		Session session=sf.openSession();
		String getAllLaboratorist="FROM Laboratorist";
		Query query=session.createQuery(getAllLaboratorist);
		return query.list();
	}

}
