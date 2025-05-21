package OneToOne;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Question.class)
				.addAnnotatedClass(Answer.class)
				.buildSessionFactory();
		
		Question q = new Question();
		q.setQuestionTitle("What is your age?");

		Answer a = new Answer();
		a.setAnswertitle("My age is 21.");
		a.setQuestion(q);
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		//this is for save data in database
//		s.save(a);
		
//		s.delete(s.get(Answer.class, 3));
		
		List<Question> list = s.createQuery("from Question").list();
		
		for (Question question : list) {
			System.out.println(question.getQuestionTitle());
			System.out.println(question.getAns().getAnswertitle());
			System.out.println("***************************");
		}
		
		tx.commit();
		
	}
	
}
