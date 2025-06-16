package com.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "subject_table")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
	private List<Question> questions;

	@OneToMany(mappedBy = "subject")
	private List<Exam> exams;

}
