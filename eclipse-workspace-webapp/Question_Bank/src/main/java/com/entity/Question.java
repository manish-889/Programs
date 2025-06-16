package com.entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToMany(mappedBy = "questions")
	private List<Exam> exams;

}
