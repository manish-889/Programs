package com.OneToMany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
	@Id
	private int answerId;
	private String answer;
	
	@ManyToOne
	private Question question;
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Answer(int answerId ,String answer) {
		super();
		this.answer = answer;
		this.answerId = answerId;
	}

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

    @Override  
    public String toString() {  
        return answer;    
    }  
	
}
