package com.fst.asustech.dao.g.stock;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.fst.asustech.dao.CrudDAO;

@Repository
public class ProduitsApprovisionnementDAOImpl implements CrudDAO<ProduitsApprovisionnementDAOImpl> {

	@Autowired
	@Qualifier("stockEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<ProduitsApprovisionnementDAOImpl> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<ProduitsApprovisionnementDAOImpl> theQuery = currentSession.createQuery("from ProduitsApprovisionnement", ProduitsApprovisionnementDAOImpl.class);
		List<ProduitsApprovisionnementDAOImpl> e = theQuery.getResultList();
		return e;
	}

	@Override
	public ProduitsApprovisionnementDAOImpl findById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(ProduitsApprovisionnementDAOImpl.class, id);
	}

	@Override
	public void save(ProduitsApprovisionnementDAOImpl e) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(e);
	}

	@Override
	public void deleteById(Long id) {
		Session currentSession = entityManager.unwrap(Session.class);
		ProduitsApprovisionnementDAOImpl e = currentSession.get(ProduitsApprovisionnementDAOImpl.class, id);
		currentSession.delete(e);
	}

}
