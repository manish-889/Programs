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
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String subjectName;
	
	@ManyToMany
	@JoinTable(
			name = "st_sub",
			joinColumns = @JoinColumn(name = "subId"),
			inverseJoinColumns = @JoinColumn(name = "stId")
			)
	List<Student> students;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public void addStduent(Student st) {
		if(students==null) {
			students = new ArrayList<Student>();
		}
		students.add(st);
	}
	
}
