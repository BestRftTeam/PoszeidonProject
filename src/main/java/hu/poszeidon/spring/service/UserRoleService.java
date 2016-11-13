package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.UserRole;

public interface UserRoleService {
    UserRole findById(int id);
    
    UserRole findByType(String type);
     
    List<UserRole> findAll();
     
}
