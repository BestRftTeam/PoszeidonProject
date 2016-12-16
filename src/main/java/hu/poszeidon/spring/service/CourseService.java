package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.User;

public interface CourseService {
	
	List<Course> findAll();
	
	Course findBycourseName(String courseName);
	
	void save(Course course);
}
