package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.OneToMany.Answer;
import com.OneToMany.Question;

public class CascadeExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuestionId(88);
		q1.setQuestion("What is your Dream?");
		
		Answer a1 = new Answer(558, "My dream is to Buy a big house by my own money");
		Answer a2 = new Answer(554, "To start my own business");
		Answer a3 = new Answer(559, "And have account balance of 1cr");
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswer(list);
		
		Transaction tran = session.beginTransaction();
		
		session.save(q1);
		
		tran.commit();
		session.close();
		factory.close();
	}
	
}
