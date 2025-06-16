package com.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToMany
	@JoinTable(name = "exam_questions", joinColumns = @JoinColumn(name = "exam_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
	private List<Question>  questions;
	
	@OneToMany(mappedBy = "exam")
	private List<UserResult> result;

}
