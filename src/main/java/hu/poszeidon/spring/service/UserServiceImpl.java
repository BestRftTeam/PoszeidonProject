package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.dao.UserDao;
import hu.poszeidon.spring.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public void deleteUserByPoId(String PoId) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByPoId(String PoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

}
