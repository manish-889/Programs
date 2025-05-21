package Main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import Model.Student;
import Model.Subject;


public class Running {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
		
		
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Subject s1 = new Subject();
		s1.setSubjectName("Node");
		
		Subject s2 = s.load(Subject.class, 1);
		
		Student st1 = new Student();
		st1.setStudentName("Hariom");
		st1.addSubject(s1);
		st1.addSubject(s2);
		
		s.save(s1);
		s.save(st1);
		
		tx.commit();
		
	}
	
}
