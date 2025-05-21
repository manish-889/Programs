package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Instructor;
import Model.Student;
import Model.Subject;
import Model.YoutubeChannel;

public class AddData {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
							.addAnnotatedClass(Instructor.class)
							.addAnnotatedClass(YoutubeChannel.class)
							.addAnnotatedClass(Subject.class)
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Instructor i1 = new Instructor();
		i1.setInsName("Manish");
		
		YoutubeChannel y1 = new YoutubeChannel();
		y1.setChName("CodeWithManish");
		y1.setIns(i1);
		
		Subject sub1 = new Subject();
		sub1.setSubName("Java"); 
		sub1.setIns(i1);
		
		
		Student st1 = new Student();
		st1.setStName("Hariom");
		st1.addSubject(sub1);
		
		sub1.addStudent(st1);
		
		Instructor i2 = new Instructor();
		i2.setInsName("Kiran");
		
		YoutubeChannel y2 = new YoutubeChannel();
		y2.setChName("Python Learning");
		y2.setIns(i2);
		
		Subject sub2 = new Subject();
		sub2.setSubName("Python");
		sub2.setIns(i2);
		
		Student st2 = new Student();
		st2.setStName("tarun");
		st2.addSubject(sub2);
		
		sub2.addStudent(st2);
	
		s.save(i1);
		s.save(i2);
		s.save(y1);
		s.save(y2);
		s.save(st1);
		s.save(st2);
		s.save(sub1);
		s.save(sub2);
		
		tx.commit();
		
	}
	
}
