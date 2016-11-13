package hu.poszeidon.spring.dao;

import java.util.List;

import hu.poszeidon.spring.model.UserRole;

public interface UserRoleDao {

    List<UserRole> findAll();
    
    UserRole findByType(String type);
     
    UserRole findById(int id);
}