package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.MedicineDao;
import com.rest.java.entity.Medicine;

@Repository
public class MedicineDaoImpl implements MedicineDao {

	@Autowired
	private SessionFactory sf;

	@Override
	public Medicine createMedicine(Medicine medicine) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(medicine);
		tx.commit();
		session.close();
		return medicine;
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(medicine);
		tx.commit();
		session.close();
		return medicine;
	}

	@Override
	public Medicine getOneMedicineById(Integer medicine_Id) {
		Session session=sf.openSession();
		Medicine medicine=session.get(Medicine.class,	medicine_Id);
		session.close();
		return medicine;
	}

	@Override
	public Medicine deleteMedicine(Integer medicine_Id) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		Medicine medicine=session.get(Medicine.class, medicine_Id);
		if(medicine !=null) {
			medicine.setMedicine_Id(medicine_Id);
			session.delete(medicine);
		}
		tx.commit();
		session.close();
		return medicine;
	}

	@Override
	public List<Medicine> getAllMedicine() {
		Session session =sf.openSession();
		String getAllMedicines="FROM Medicine";
		Query query=session.createQuery(getAllMedicines);
		return query.list();
	}

}
