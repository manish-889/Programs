package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "result")
public class UserResult {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "exam_id")
	private Exam exam;


}
