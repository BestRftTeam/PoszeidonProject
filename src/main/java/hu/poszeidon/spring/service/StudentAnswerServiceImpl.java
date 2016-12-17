package hu.poszeidon.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.model.StudentAnswer;
import hu.poszeidon.spring.repositories.StudentAnswerRepository;

@Service("studentAnswerService")
public class StudentAnswerServiceImpl implements StudentAnswerService {
	
	@Autowired
	private StudentAnswerRepository studentAnswerRepository; 

	@Transactional
	public void save(StudentAnswer studentAnswer){
		studentAnswerRepository.save(studentAnswer);
	}

	@Transactional
	public StudentAnswer findById(int id) {
		return studentAnswerRepository.findById(id);
	}
	
}
