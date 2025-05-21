package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int subId;
	String subName;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	Instructor ins;
	
	@ManyToMany()
	@JoinTable(
			name = "st_sub",
			joinColumns = @JoinColumn(name = "subId"),
			inverseJoinColumns = @JoinColumn(name = "stId")
 			)
	List<Student> students;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Instructor getIns() {
		return ins;
	}

	public void setIns(Instructor ins) {
		this.ins = ins;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStudent(Student st) {
		if(students==null) {
			students = new ArrayList<Student>();
		}
		students.add(st);
	}
}
