package hu.poszeidon.spring.service;

import java.util.List;

import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.Learning;
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.model.User;

public interface CourseService {
	
	List<Course> findAll();
	
	Course findBycourseName(String courseName);
	
	void save(Course course);
	
	Course findById(int id);
	
	
	public void addLearning(Course course, Learning learning );
	
	public void addTest(Course course,Teszt teszt);
}
