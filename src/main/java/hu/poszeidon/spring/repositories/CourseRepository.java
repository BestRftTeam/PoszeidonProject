package hu.poszeidon.spring.repositories;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.Course;

@Repository("course")
public interface CourseRepository extends BaseRepository<Course, Integer> {
	

}
