package OneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int qId;
	String questionTitle;
	
	@OneToOne(mappedBy = "question" ,cascade = CascadeType.ALL)
	Answer ans;

	public int getqId() {
		return qId;
	}

	public void setqId(int qId) {
		this.qId = qId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Answer getAns() {
		return ans;
	}

	public void setAns(Answer ans) {
		this.ans = ans;
	}
	
	
	
}
