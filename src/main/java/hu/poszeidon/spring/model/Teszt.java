package hu.poszeidon.spring.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
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
	private Date availability;

	@Column(name = "START_DATE")
	private LocalDateTime starDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "START_TIME")
	private LocalDateTime startTime;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "TEST_QArepo", joinColumns = {
			@JoinColumn(name = "TEST_ID", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "QAREPO_ID", referencedColumnName = "id") })
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

	public List<QArepo> getTestSheet() {
		return testSheet;
	}

	public void setTestSheet(List<QArepo> testSheet) {
		this.testSheet = testSheet;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public Date getAvailability() {
		return availability;
	}

	public void setAvailability(Date availability) {
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

	public void addQArepo(QArepo qarepo) {
		this.testSheet.add(qarepo);
	}

	@Override
	public String toString() {
		return "Teszt [id=" + id + ", testName=" + testName + ", availability=" + availability + ", starDate="
				+ starDate + ", endDate=" + endDate + ", startTime=" + startTime + ", testSheet=" + testSheet + "]";
	}



}