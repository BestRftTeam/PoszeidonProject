package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import hu.poszeidon.spring.model.User;

public interface UserService {
	
	List<User> findAll();
	
	void save(User user);
	
	User findByPoszId(String poszId);

	User findByEmail(String Email);

	void delete(User user);
	
}
