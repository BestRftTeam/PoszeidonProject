package hu.poszeidon.spring.dao;

import java.util.List;

import hu.poszeidon.spring.model.User;

public interface UserDao {

	void saveUser(User user);
	
	List<User> findAllUsers();
	
	void deleteUserByPoId(String PoId);
	
	User findById(int id);
	
	User findByPoId(String PoId);
	
	void updateUser(User user);
}