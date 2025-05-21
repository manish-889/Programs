package Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Answer;
import Model.Question;

public class View {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		List<Question> list = s.createQuery("from Question").list();
		
		for (Question question : list) {
			System.out.println(question.getQuestionTitle());
			System.out.println(question.getAns().getAnswerTitle());
			System.out.println("******************************");
		}
		
		
		tx.commit();
		
	}
	
}
