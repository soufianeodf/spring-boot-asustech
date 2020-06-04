package com.fst.asustech.dao.g.vente;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fst.asustech.entity.g.vente.Commandes;

public class CommandesRepositoryImpl implements CommandesRepositoryCustom {

	@Autowired
	@Qualifier("venteEntityManagerFactory")
	private EntityManager entityManager;

	@Override
	public List<Commandes> findUserCommands(String userName) {

		Session currentSession = entityManager.unwrap(Session.class);

		String hql = "select commandes "
				+ " from ProduitsPrix produitsPrix, Commandes commandes, Users users "
				+ " where produitsPrix.codePdt=commandes.codePdt and commandes.client=users.username and users.username=:userName";

		Query query = currentSession.createQuery(hql);
		query.setParameter("userName", userName);
		List<Commandes> e = query.getResultList();

		return e;
	}

}
