package hu.poszeidon.spring.repositories;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.Learning;


@Repository("learning")
public interface LearningRepository extends BaseRepository<Learning, Integer> {

}
