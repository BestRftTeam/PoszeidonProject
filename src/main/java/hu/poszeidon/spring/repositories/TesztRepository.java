
package hu.poszeidon.spring.repositories;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.Teszt;

@Repository("teszt")
public interface TesztRepository extends BaseRepository<Teszt, Integer> {

}