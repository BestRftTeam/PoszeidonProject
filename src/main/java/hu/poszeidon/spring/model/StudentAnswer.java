package hu.poszeidon.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "STUDENT_ANSWER")
//@Embeddable
public class StudentAnswer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name = "TEST_ID", unique = true, nullable = false)
	private int testID;
	
	@Column(name = "TEST_NAME")
	private String testName;
	
	@Column(name = "SUM_SCORE")
	private double sumScore;
	
	@ElementCollection
	private List<Double> scoreList = new ArrayList<Double>();
	
//	@ElementCollection
//	@CollectionTable(name="COLLECTION")
	@Embedded
	private Collection<List<Boolean>> collection = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestID() {
		return testID;
	}

	public void setTestID(int testID) {
		this.testID = testID;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public double getSumScore() {
		return sumScore;
	}

	public void setSumScore(double sumScore) {
		this.sumScore = sumScore;
	}

	public List<Double> getScoreList() {
		return scoreList;
	}

	public void setScoreList(List<Double> scoreList) {
		this.scoreList = scoreList;
	}
/*
	public Collection<List<Boolean>> getCollection() {
		return collection;
	}
	public void setCollection(Collection<List<Boolean>> collection) {
		this.collection = collection;
	}
*/	
    private void addScoretoList(Double score){
    	this.scoreList.add(score);
    }
/*	
    private void addListtoCollection(List<Boolean> list){
    	this.collection.add(list);
    }
  */  
}