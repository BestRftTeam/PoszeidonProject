package hu.poszeidon.spring.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import hu.poszeidon.spring.model.Course;

@Repository("course")
public interface CourseRepository extends BaseRepository<Course, Integer> {

	Course findBycourseName(String courseName);
	
	Course findById(int id);
}
