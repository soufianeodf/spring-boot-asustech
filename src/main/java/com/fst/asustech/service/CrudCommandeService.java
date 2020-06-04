package com.fst.asustech.service;

import java.util.List;

import com.fst.asustech.entity.g.vente.Commandes;

public interface CrudCommandeService extends CrudService<Commandes> {

	List<Object[]> findUserCommands(String userName);
}
