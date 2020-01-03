package com.rest.java.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.java.dao.MedicineCategoryDao;
import com.rest.java.entity.MedicineCategory;

@Repository
public class MedicineCategoryDaoImpl implements MedicineCategoryDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public MedicineCategory createMedicineCategory(MedicineCategory medicineCategory) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.save(medicineCategory);
		tx.commit();
		session.close();
		return medicineCategory;
	}

	@Override
	public MedicineCategory updateMedicineCategory(MedicineCategory medicineCategory) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		session.update(medicineCategory);
		tx.commit();
		session.close();
		return medicineCategory;
	}

	@Override
	public MedicineCategory getMedicineCategory(Integer medId) {
		Session session=sf.openSession();
		MedicineCategory medicine=session.get(MedicineCategory.class, medId);
		return medicine;
	}

	@Override
	public MedicineCategory deleteMedicineCategory(Integer medId) {
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		MedicineCategory medicine=session.get(MedicineCategory.class, medId);
		if(medicine!=null) {
		medicine.setMedId(medId);
		session.delete(medicine);
		}
		tx.commit();
		session.close();
		
		return medicine;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicineCategory> getAllMedicineCategories() {
		Session session=sf.openSession();
		String getAllMedicineCategories="FROM MedicineCategory";
		Query query=session.createQuery(getAllMedicineCategories);
		return query.list();
	}

}
