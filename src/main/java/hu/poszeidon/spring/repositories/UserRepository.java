package hu.poszeidon.spring.repositories;


import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.User;

@Repository("user")
public interface UserRepository extends BaseRepository<User, Integer> {
	
	User findByPoszId(String poszId);
	
	User findByEmail(String email);
	
	User saveAndFlush(User user);

}
