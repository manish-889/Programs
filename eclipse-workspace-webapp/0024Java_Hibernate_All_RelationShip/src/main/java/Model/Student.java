package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stId;
	String stName;

	@ManyToMany()
	@JoinTable(
			name = "st_sub",
			joinColumns = @JoinColumn(name = "stId"),
			inverseJoinColumns = @JoinColumn(name = "subId")
 			)
	List<Subject> subjects;

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void addSubject(Subject s) {
		if(subjects==null) {
			subjects = new ArrayList<Subject>();
		}
		subjects.add(s);
	}
}
