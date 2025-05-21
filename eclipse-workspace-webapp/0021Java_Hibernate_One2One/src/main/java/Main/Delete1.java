package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Answer;
import Model.Question;

public class Delete1 {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(s.load(Question.class, 1));
		
		tx.commit();
		
	}
	
}
