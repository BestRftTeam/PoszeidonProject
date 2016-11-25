package hu.poszeidon.spring.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TESZT")
public class Teszt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name = "TEST_NAME", nullable = false)
	private String testName;
	
	@Column(name = "AVAILABILITY")
	private Duration availability;
	
	@Column(name = "START_DATE")
	private LocalDateTime starDate;
	
	@Column(name = "END_DATE")
	private LocalDateTime endDate;
	
	@Column(name = "START_TIME")
	private LocalDateTime startTime;
	/*
	@ElementCollection
	@CollectionTable(name = "QATABLE")
    @Column(name = "SAM")
    @MapKeyJoinColumn(name = "question_id", referencedColumnName = "id")
	private Map<Integer,QArepo> answerList = new HashMap<>();
	
*/
	@ElementCollection
	@CollectionTable(name = "TESTSHEET")
	private List<QArepo> testSheet = new ArrayList<QArepo>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Duration getAvailability() {
		return availability;
	}

	public void setAvailability(Duration availability) {
		this.availability = availability;
	}

	public LocalDateTime getStarDate() {
		return starDate;
	}

	public void setStarDate(LocalDateTime starDate) {
		this.starDate = starDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	

}
