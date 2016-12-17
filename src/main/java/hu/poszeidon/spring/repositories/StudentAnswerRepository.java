package hu.poszeidon.spring.repositories;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.StudentAnswer;

@Repository("studentAnswer")
public interface StudentAnswerRepository extends BaseRepository<StudentAnswer, Integer>{

}
