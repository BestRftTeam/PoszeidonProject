package hu.poszeidon.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "STUDENT_ANSWER")
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

	@Column(name = "MAX_SCORE")
	private int maxScore;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Double> scoreList = new ArrayList<Double>();

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Boolean> answerList = new ArrayList<Boolean>();

	@ManyToOne(fetch = FetchType.EAGER)//,cascade = CascadeType.ALL)
	@JoinTable(name = "USER_STUDENTANSWER", joinColumns={@JoinColumn(name = "STUDENTANSWER_ID",referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID",referencedColumnName = "id")})
	private User user;
	
	public void examination(Teszt tests) {
		int ansListIndex = 0;
		this.scoreList.clear();
		int max = 0;
		for (QArepo qarepo : tests.getTestSheet()) {
			double score = 0.0;
			max += qarepo.getScore();
			double mod = (double) qarepo.getScore() / (double) qarepo.getAnswers().size();
			for (Boolean bol : qarepo.getAnswers()) {
				if (bol == this.answerList.get(ansListIndex)) {
					score += mod;
				} else {
					score -= mod;
				}
				ansListIndex += 1;
			}
			if (score < 0.0) {
				this.scoreList.add(0.0);
			} else {
				this.scoreList.add(score);
			}

		}
		this.sumScore = this.scoreList.stream().mapToDouble(Double::doubleValue).sum();
		this.maxScore = max;
	}

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

	public List<Boolean> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Boolean> answerList) {
		this.answerList = answerList;
	}

	private void addScoretoList(Double score) {
		this.scoreList.add(score);
	}

	private void addAnswertoList(Boolean bool) {
		this.answerList.add(bool);
	}

}
