package com.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	
	@Id
	private int questionId;
	private String question;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Answer> answer;
	
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(String question, List<Answer> answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
	
}
