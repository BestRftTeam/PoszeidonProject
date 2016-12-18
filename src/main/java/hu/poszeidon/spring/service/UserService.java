package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.StudentAnswer;
import hu.poszeidon.spring.model.User;

public interface UserService {
	
	List<User> findAll();
	
	void save(User user);
	
	User findByPoszId(String poszId);
	
	User findByEmail(String email);
	
	void addStudentAnswer(User user,StudentAnswer studentAnswer);

	
}
