package com.SpringDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.entity.Student;

@Configuration("studentDao")
public class StudentDaoImp implements StudentDao {

	@Autowired
	private JdbcTemplate jtemp;
	
	//for inserting data
	@Override
	public int insert(Student student) {
		String query = "INSERT INTO Student(id,name,city) VALUES (?,?,?) ";
		int r = jtemp.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	//for update data
	@Override
	public int update(Student student) {
		String query = "UPDATE student SET name = ?, city = ? WHERE id = ?";
		int r = jtemp.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}

	//for getting single object
	@Override
	public Student getStudent(int Id) {
		String query = "SELECT * FROM student WHERE id = ?";
		RowMapper<Student> rm = new RowMapperImp();
		Student st = jtemp.queryForObject(query, rm, Id);
		return st;
	}

	//for getting all object
	@Override
	public List<Student> getAllStudent() {
		String query = "SELECT * FROM student";
		List<Student> list = jtemp.query(query, new RowMapperImp());
		return list;
	}
	
	public JdbcTemplate getJtemp() {
		return jtemp;
	}

	public void setJtemp(JdbcTemplate jtemp) {
		this.jtemp = jtemp;
	}

	

}
