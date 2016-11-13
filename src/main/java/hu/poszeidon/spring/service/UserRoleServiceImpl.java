package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.dao.UserRoleDao;
import hu.poszeidon.spring.model.UserRole;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
    UserRoleDao dao;
	
	public UserRole findById(int id) {
		return dao.findById(id);
	}

	public UserRole findByType(String type) {
		return dao.findByType(type);
	}

	public List<UserRole> findAll() {
		return dao.findAll();
	}

}
