package com.fst.asustech.service.g.vente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fst.asustech.dao.g.vente.CommandesRepository;
import com.fst.asustech.dao.g.vente.CommandesRepositoryImpl;
import com.fst.asustech.entity.g.vente.Commandes;
import com.fst.asustech.service.CrudCommandeService;

@Service
public class CommandesServiceImpl implements CrudCommandeService {

	@Autowired
	@Qualifier("commandesRepository")
	private CommandesRepository commandesRepository;
	
	@Autowired
	CommandesRepositoryImpl commandesRepositoryImpl;

	@Override
	public List<Commandes> findAll() {
		return commandesRepository.findAll();
	}

	@Override
	public Commandes findById(Integer id) {
		Optional<Commandes> result = commandesRepository.findById(id);
		Commandes commandes = null;
		if (result.isPresent()) {
			commandes = result.get();
		} else {
			throw new RuntimeException("Did not find commandes");
		}
		return commandes;
	}

	@Override
	public void save(Commandes e) {
		commandesRepository.save(e);
	}

	@Override
	public void deleteById(Integer id) {
		commandesRepository.deleteById(id);
	}
	
	@Override
	public List<Object[]> findUserCommands(String userName) {
		return commandesRepositoryImpl.findUserCommands(userName);
	}

}
