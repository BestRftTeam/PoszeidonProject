package hu.poszeidon.spring.repositories;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.QArepo;

@Repository("qarepo")
public interface QArepoRepository extends BaseRepository<QArepo, Integer> {

}
