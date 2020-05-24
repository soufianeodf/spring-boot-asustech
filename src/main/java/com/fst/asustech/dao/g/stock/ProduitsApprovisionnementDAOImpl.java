package com.fst.asustech.dao.g.stock;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;
import com.fst.asustech.entity.g.stock.ProduitsApprovisionnement;

@Repository
public class ProduitsApprovisionnementDAOImpl implements CrudDAO<ProduitsApprovisionnement> {

	@Autowired
	@Qualifier("stockEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<ProduitsApprovisionnement> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProduitsApprovisionnement> theQuery = currentSession.createQuery("from ProduitsApprovisionnement", ProduitsApprovisionnement.class);
		List<ProduitsApprovisionnement> e = theQuery.getResultList();
		return e;
	}

	@Override
	public ProduitsApprovisionnement findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(ProduitsApprovisionnement.class, id);
	}

	@Override
	public void save(ProduitsApprovisionnement e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProduitsApprovisionnement e = currentSession.get(ProduitsApprovisionnement.class, id);
		currentSession.delete(e);
	}

}
