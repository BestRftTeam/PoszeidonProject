package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.model.User;
import hu.poszeidon.spring.repositories.UserRepository;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private  UserRepository userRepository;

	@Transactional
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}

	@Transactional
	public User findByPoszId(String poszId) {
		return userRepository.findByPoszId(poszId);
	}

	@Override
	public User findByEmail(String Email) {
		return userRepository.findByEmail(Email);
	}

}
