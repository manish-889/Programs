package OneToOne;

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
	String answertitle;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "qId")
	Question question;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getAnswertitle() {
		return answertitle;
	}

	public void setAnswertitle(String answertitle) {
		this.answertitle = answertitle;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
	
}
