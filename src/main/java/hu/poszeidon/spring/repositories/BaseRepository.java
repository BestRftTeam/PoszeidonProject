package hu.poszeidon.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import hu.poszeidon.spring.model.User;

import java.io.Serializable;

import java.util.List;
import java.util.Optional;
 
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends CrudRepository<T,ID>{
 

}
