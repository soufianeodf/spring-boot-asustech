package com.fst.asustech.dao.g.vente;

import java.util.List;

public interface CommandesRepositoryCustom {
	
	List<Object[]> findUserCommands(String userName);
	
}
