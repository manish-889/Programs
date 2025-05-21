package Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Student;
import Model.Subject;


public class View1 {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Subject.class)
				.buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
	
		List<Student> list = s.createQuery("from Student").list();
		
		for (Student student : list) {
			System.out.println(student.getId()+" "+student.getStudentName());
			for (Subject sub : student.getSubjets()) {
				System.out.println(sub.getId()+" "+sub.getSubjectName());
			}
			System.out.println("________________________________");
		}
		
		tx.commit();
		
	}
	
}
