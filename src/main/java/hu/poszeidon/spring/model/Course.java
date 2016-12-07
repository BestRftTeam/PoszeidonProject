package hu.poszeidon.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;
	
	//private String courseLeader;
	private User courseLeader;
	
	@ManyToMany(fetch = FetchType.EAGER)//cascade = CascadeType.ALL)//
	@JoinTable(name = "USER_COURSE", joinColumns = { @JoinColumn(name = "COURSE_ID",referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID",referencedColumnName = "id") })
	private Set<User> studentList;
	
	
	@ElementCollection
	@CollectionTable(name = "LEARNING")
	private List<Learning> learnings = new ArrayList<Learning>();
	
	
	@ElementCollection
	@CollectionTable(name = "TEST")
	private List<Teszt> tests = new ArrayList<Teszt>();

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

//	@ManyToMany(mappedBy = "COURSE")
	public User getCourseLeader() {
		return courseLeader;
	}

	public void setCourseLeader(User courseLeader) {
		this.courseLeader = courseLeader;
	}


	
/*
	public String getCourseLeader() {
		return courseLeader;
	}

	public void setCourseLeader(String courseLeader) {
		this.courseLeader = courseLeader;
	}
	
	*/

	public Set<User> getStudentList() {
		return studentList;
	}
	public void setStudentList(Set<User> studentList) {
		this.studentList = studentList;
	}

	
	
	
	public List<Learning> getLearnings() {
		return learnings;
	}

	public void setLearnings(List<Learning> learnings) {
		this.learnings = learnings;
	}

	public List<Teszt> getTests() {
		return tests;
	}

	public void setTests(List<Teszt> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + "]";
	}


	
}
