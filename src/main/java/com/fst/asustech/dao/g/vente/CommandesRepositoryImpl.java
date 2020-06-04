package com.fst.asustech.dao.g.vente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CommandesRepositoryImpl implements CommandesRepositoryCustom {

	@Autowired
	@Qualifier("venteEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<Object[]> findUserCommands(String userName) {

		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "select commandes, produitsPrix.prixPdt "
				+ " from ProduitsPrix produitsPrix, Commandes commandes, Users users "
				+ " where produitsPrix.codePdt=commandes.codePdt and commandes.client=users.username and users.username=:userName";

		Query query = currentSession.createQuery(hql);
		query.setParameter("userName", userName);
		List<Object[]> e = query.getResultList();

		return e;
	}

}
