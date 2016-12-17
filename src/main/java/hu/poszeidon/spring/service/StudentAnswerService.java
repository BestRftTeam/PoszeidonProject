package hu.poszeidon.spring.service;

import hu.poszeidon.spring.model.StudentAnswer;

public interface StudentAnswerService {

	StudentAnswer findById(int id); 
	
	void save(StudentAnswer studentAnswer);
}
