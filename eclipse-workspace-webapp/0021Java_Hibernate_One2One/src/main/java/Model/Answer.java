package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int aId;
	String answerTitle;
	
	@OneToOne(mappedBy = "ans", cascade = CascadeType.ALL)
	@JoinColumn(name = "qId")
	Question que;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public Question getQue() {
		return que;
	}

	public void setQue(Question que) {
		this.que = que;
	}
	
	
	
}
