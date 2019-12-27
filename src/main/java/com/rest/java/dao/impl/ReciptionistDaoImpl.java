package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.ReciptionistDao;
import com.rest.java.entity.Reciptionist;
@Repository
public class ReciptionistDaoImpl implements ReciptionistDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Reciptionist addReciptionist(Reciptionist reciptionist) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(reciptionist);
		tx.commit();
		session.close();
		return reciptionist;
	}

	@Override
	public Reciptionist updateReciptionist(Reciptionist reciptionist) {
		Session session =sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(reciptionist);
		tx.commit();
		session.close();
		return reciptionist;
	}

	@Override
	public Reciptionist getOneReciptionist(Integer recpId) {
		Session session=sf.openSession();
		Reciptionist reciptionist =session.get(Reciptionist.class, recpId);
		session.close();
		return reciptionist;
	}

	@Override
	public Reciptionist deleteReciptionist(Integer recpId) {
		Session session=sf.openSession();
		Reciptionist reciptionist =session.get(Reciptionist.class, recpId);
		if(reciptionist!=null) {
			reciptionist.setRecpId(recpId);
			session.delete(reciptionist);
		}
		return reciptionist;
	}

	@Override
	public List<Reciptionist> getAllReciptionist() {
		Session session=sf.openSession();
		String getAll="FROM Reciptionist";
		Query query=session.createQuery(getAll);
		return query.list();
	}

}
