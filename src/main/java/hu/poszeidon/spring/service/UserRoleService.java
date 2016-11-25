package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.UserRole;
import hu.poszeidon.spring.model.UserRoleType;

public interface UserRoleService {
    UserRole findByOne(int id);
       
     
    UserRole findByUserRoleType(UserRoleType userRoleType);
    
 //   List<UserRole> findAll();
}
