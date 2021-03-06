package hu.poszeidon.spring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "USER")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(name = "POSZ_ID", unique = true, nullable = false)
	private String poszId;

	@NotEmpty
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@NotEmpty
	@Column(name = "Last_NAME", nullable = false)
	private String lastName;

	@NotEmpty
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@NotEmpty
	@Column(name = "EMAIL", nullable = true)
	private String email;

	@NotEmpty
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ROLE_ID") })
	private Set<UserRole> userRoles = new HashSet<UserRole>();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_COURSE", joinColumns = { @JoinColumn(name = "USER_ID",referencedColumnName = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "COURSE_ID",referencedColumnName = "id") })
	private Set<Course> courses ;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_STUDENTANSWER", joinColumns={@JoinColumn(name = "USER_ID",referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "STUDENTANSWER_ID",referencedColumnName = "id")})
	private Set<StudentAnswer> tesztAnsewrs =  new HashSet<StudentAnswer>();
	
	
	public User(String poszId, String firstName, String lastName, String password, String email, Set<UserRole> userRoles) {
	this.poszId = poszId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.email = email;
	this.userRoles = userRoles;
}
	public User(String poszId, String firstName, String lastName, String password, String email) {
	this.poszId = poszId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.email = email;
}
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void addUserRole(UserRole userRole){
		this.userRoles.add(userRole);
	}

	
	public String getPoszId() {
		return poszId;
	}

	public void setPoszId(String poszId) {
		this.poszId = poszId;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public void addtesztAnsewr(StudentAnswer studentAnswer){
		this.tesztAnsewrs.add(studentAnswer);
	}
	
	public Set<StudentAnswer> getTesztAnsewrs() {
		return tesztAnsewrs;
	}
	public void setTesztAnsewrs(Set<StudentAnswer> tesztAnsewrs) {
		this.tesztAnsewrs = tesztAnsewrs;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", poszId=" + poszId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", email=" + email + ", userRoles=" + userRoles + ", courses=" + courses
				+ "]";
	}

	public boolean HasCourse(String CourseName){
		for (Course c : this.getCourses()){
			if (c.getCourseName().equals(CourseName)) return true;
		}
		return false;
	}
	



}