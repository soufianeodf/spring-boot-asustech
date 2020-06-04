package com.fst.asustech.dao.g.vente;

import java.util.List;

import com.fst.asustech.entity.g.vente.Commandes;

public interface CommandesRepositoryCustom {
	
	List<Commandes> findUserCommands(String userName);
	
}
