package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Answer;
import Model.Question;

public class Running {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
		
		Answer a =  new Answer();
		a.setAnswerTitle("Java is oops programming.");
		
		Question q = new Question();
		q.setQuestionTitle("What is Java?");
		q.setAns(a);
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(q);
		tx.commit();
		
	}
	
}
