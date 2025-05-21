package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int iId;
	String insName;
	
	@OneToOne(mappedBy = "ins", cascade = CascadeType.ALL)
	YoutubeChannel yt;
	
	@OneToMany(mappedBy = "ins",cascade = CascadeType.ALL)
	List<Subject> sub;

	public int getiId() {
		return iId;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public YoutubeChannel getYt() {
		return yt;
	}

	public void setYt(YoutubeChannel yt) {
		this.yt = yt;
	}

	public List<Subject> getSub() {
		return sub;
	}

	public void setSub(List<Subject> sub) {
		this.sub = sub;
	}
	
	public void addSubject(Subject s) {
		if(sub==null) {
			sub = new ArrayList<Subject>();
		}
		sub.add(s); 
	}
}
