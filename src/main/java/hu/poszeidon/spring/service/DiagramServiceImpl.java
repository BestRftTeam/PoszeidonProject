package hu.poszeidon.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.model.StudentAnswer;
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.repositories.TesztRepository;
import hu.poszeidon.spring.repositories.UserRepository;

@Service("diagramService")
public class DiagramServiceImpl implements DiagramService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TesztRepository tesztRepository;

	@Transactional
	public int getAllMaxScore(User user) {
		int sum = 0;
		for (StudentAnswer studenAns : user.getTesztAnsewrs()) {
			sum += studenAns.getMaxScore();
		}
		return sum;
	}

	@Transactional
	public double getAllScore(User user) {
		int sum = 0;
		for (StudentAnswer studenAns : user.getTesztAnsewrs()) {
			sum += studenAns.getSumScore();
		}
		return sum;
	}

	@Transactional
	public void examinationsAll(User user) {
		for (StudentAnswer studenans : user.getTesztAnsewrs()) {
			Teszt teszt = tesztRepository.findBytestName(studenans.getTestName());
			studenans.examination(teszt);
		}
		userRepository.save(user);
	}


	
}
