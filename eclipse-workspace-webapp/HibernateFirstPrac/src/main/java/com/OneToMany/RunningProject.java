package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunningProject {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Question q1 = new Question();
		q1.setQuestionId(121);
		q1.setQuestion("What is java?");

		Answer ans1 = new Answer();
		ans1.setAnswerId(167);
		ans1.setAnswer("It's a programming language.");
		ans1.setQuestion(q1);

		Answer ans2 = new Answer();
		ans2.setAnswerId(235);
		ans2.setAnswer("It has many Framework.");
		ans2.setQuestion(q1);

		Answer ans3 = new Answer();
		ans3.setAnswerId(421);
		ans3.setAnswer("Java is widely used language.");
		ans3.setQuestion(q1);

		List<Answer> list = new ArrayList<Answer>();

		list.add(ans1);
		list.add(ans2);
		list.add(ans3);

		q1.setAnswer(list);

		Question q2 = new Question();
		q2.setQuestionId(131);
		q2.setQuestion("Tell me about your self?");

		Answer a1 = new Answer();
		a1.setAnswerId(34);
		a1.setAnswer("My name is manish giri.");
		a1.setQuestion(q2);

		Answer a2 = new Answer();
		a2.setAnswerId(98);
		a2.setAnswer("I lived in kim.");
		a2.setQuestion(q2);

		Answer a3 = new Answer();
		a3.setAnswerId(01);
		a3.setAnswer("I am Software Developer.");
		a3.setQuestion(q2);

		List<Answer> list2 = new ArrayList<Answer>();

		list2.add(a1);
		list2.add(a2);
		list2.add(a3);

		q2.setAnswer(list2);

		Session session = factory.openSession();

		Transaction tr = session.beginTransaction();

//		session.save(q1);
//		
//		session.save(ans1);
//		session.save(ans2);
//		session.save(ans3);
//		
//		session.save(q2);																				
//		
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);

		System.out.println("Question no 1..");
		Question q = (Question) session.get(Question.class, 121);

		System.out.println(q.getQuestion());

		for (Answer answer : q.getAnswer()) {
			System.out.println(answer);
		}
		
		System.out.println();
		System.out.println("Questuon no 2...");
		Question qu = (Question) session.get(Question.class, 131);

		System.out.println(qu.getQuestion());

		for (Answer answer : qu.getAnswer()) {
			System.out.println(answer);
		}

		tr.commit();
		session.close();
		factory.close();
	}
}
