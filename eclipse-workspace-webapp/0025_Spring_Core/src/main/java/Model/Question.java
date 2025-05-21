package Model;

import java.util.List;

public class Question {

	private int qno;
	String question;
	List<Answer> ans;
	
	public void display() {
		System.out.println(qno+" "+question);
		for (Answer answer : ans) {
			answer.display();
		}
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public List<Answer> getAns() {
		return ans;
	}

	public void setAns(List<Answer> ans) {
		this.ans = ans;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	
}
