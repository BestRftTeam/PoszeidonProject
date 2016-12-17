package hu.poszeidon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.poszeidon.spring.model.Course;
import hu.poszeidon.spring.model.Learning;
import hu.poszeidon.spring.model.Teszt;
import hu.poszeidon.spring.repositories.CourseRepository;

import hu.poszeidon.spring.repositories.UserRepository;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private UserRepository userRepository;


	
	@Transactional
	public List<Course> findAll() {
		return (List<Course>) courseRepository.findAll();
	}

	@Transactional
	public void save(Course course) {
		courseRepository.save(course);
		
	}
	@Transactional
	public Course findBycourseName(String courseName) {
		return (Course) courseRepository.findBycourseName(courseName);
	}
	
	@Transactional
	public void addLearning(Course course, Learning learning ){
		course.addLearning(learning);
		courseRepository.save(course);
		
	}
	

	@Transactional
	public Course findById(int id) {
		
		return courseRepository.findById(id);
	}

	@Transactional
	public void addTest(Course course, Teszt teszt) {
		course.addTest(teszt);
		courseRepository.save(course);
		
	}
}
