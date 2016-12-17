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

import org.aspectj.weaver.ast.Test;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "COURSE")
public class Course implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name = "COURSE_NAME", nullable = false)
	private String courseName;

	// private String courseLeader;
	private User courseLeader;

	@ManyToMany(fetch = FetchType.EAGER) // cascade = CascadeType.ALL)//
	@JoinTable(name = "USER_COURSE", joinColumns = {
			@JoinColumn(name = "COURSE_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "USER_ID", referencedColumnName = "id") })
	private Set<User> studentList;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "LEARNING", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"))
	@Column(name = "LEARNINGS")
	private List<Learning> learnings = new ArrayList<Learning>();

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //
	@JoinTable(name = "COURSE_TEST", joinColumns = {
			@JoinColumn(name = "COURSE_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "TEST_ID", referencedColumnName = "id") })
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

	public User getCourseLeader() {
		return courseLeader;
	}

	public void setCourseLeader(User courseLeader) {
		this.courseLeader = courseLeader;
	}


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

	public void addLearning(Learning learning) {
		this.learnings.add(learning);
	}

	public void addTest(Teszt test) {
		this.tests.add(test);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + "]";
	}

}
