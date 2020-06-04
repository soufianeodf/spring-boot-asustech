//package com.fst.asustech.service.g.vente;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.fst.asustech.dao.g.vente.UsersRepository;
//import com.fst.asustech.entity.g.vente.Users;
//import com.fst.asustech.service.CrudService;
//
//@Service
//public class UsersServiceImpl implements CrudService<Users> {
//
//	@Autowired
//	@Qualifier("usersRepository")
//	private UsersRepository usersRepository;
//
//	@Override
//	public List<Users> findAll() {
//		return usersRepository.findAll();
//	}
//
//	@Override
//	public Users findById(Integer id) {
//		Optional<Users> result = usersRepository.findById(id);
//		Users users = null;
//		if (result.isPresent()) {
//			users = result.get();
//		} else {
//			throw new RuntimeException("Did not find users");
//		}
//		return users;
//	}
//
//	@Override
//	public void save(Users e) {
//		usersRepository.save(e);
//	}
//
//	@Override
//	public void deleteById(Integer id) {
//		usersRepository.deleteById(id);
//	}
//
//}
