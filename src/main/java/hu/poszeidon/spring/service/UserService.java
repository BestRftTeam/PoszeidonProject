package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.User;

public interface UserService {

	void saveUser(User user);

	List<User> findAllUsers();

	void deleteUserByPoId(String PoId);

	User findByPoId(String PoId);

	void updateUser(User user);
}