package hu.poszeidon.spring.service;

import hu.poszeidon.spring.model.User;

public interface DiagramService {

	int getAllMaxScore(User user);
	
	double getAllScore(User user);
	
	public void examinationsAll(User user);
	
}
