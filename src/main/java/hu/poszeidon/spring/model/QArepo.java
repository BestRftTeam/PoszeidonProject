package hu.poszeidon.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "QAREPO")
public class QArepo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "QUESTION")
	private String question;
	
	@Column(name = "SCORE")
	private int score;
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> answerOptions = new ArrayList<String>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	private List<Boolean> answers = new ArrayList<Boolean>();
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(List<String> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public List<Boolean> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Boolean> answers) {
		this.answers = answers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}



}
