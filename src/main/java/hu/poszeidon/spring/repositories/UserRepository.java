package hu.poszeidon.spring.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.User;

@Repository("user")
public interface UserRepository extends BaseRepository<User, Integer> {
	
	User findByPoszId(String poszId);
	User findByEmail(String Email);
	
	User saveAndFlush(User user);
}
