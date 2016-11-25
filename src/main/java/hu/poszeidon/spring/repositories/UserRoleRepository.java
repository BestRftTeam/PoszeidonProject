package hu.poszeidon.spring.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;

@Repository("userRole")
public interface UserRoleRepository extends BaseRepository<UserRole, Integer> {
	
	
	UserRole findByUserRoleType(UserRoleType userRoleType);
	
	

}
