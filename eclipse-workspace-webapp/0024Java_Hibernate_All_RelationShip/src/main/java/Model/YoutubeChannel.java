package Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class YoutubeChannel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int chId;
	String chName;
	
	@OneToOne(cascade = CascadeType.ALL)
	Instructor ins;

	public int getChId() {
		return chId;
	}

	public void setChId(int chId) {
		this.chId = chId;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public Instructor getIns() {
		return ins;
	}

	public void setIns(Instructor ins) {
		this.ins = ins;
	}
	
	
}
