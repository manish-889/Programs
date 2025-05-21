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
	int id;
	String studentName;
	
	@ManyToMany
	@JoinTable(
			name = "st_sub",
			joinColumns = @JoinColumn(name = "stId"),
			inverseJoinColumns = @JoinColumn(name = "subId")
			)
	List<Subject> subjets;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public List<Subject> getSubjets() {
		return subjets;
	}

	public void setSubjets(List<Subject> subjets) {
		this.subjets = subjets;
	}
	
	public void addSubject(Subject s) {
		
		if(subjets==null) {
			subjets = new ArrayList<Subject>();
		}
		subjets.add(s);
		
	}
	
}
