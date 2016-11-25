package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;
import hu.poszeidon.spring.repositories.UserRoleRepository;

@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Transactional
	public UserRole findByOne(int id) {
		return userRoleRepository.findOne(id);
	}

/*
	@Transactional
	public List<UserRole> findAll() {
		return (List<UserRole>) userRoleRepository.findAll();
	}
*/
	@Transactional
	public UserRole findByUserRoleType(UserRoleType userRoleType){
		return userRoleRepository.findByUserRoleType(userRoleType);
	}


}
