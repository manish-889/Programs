package hibernate.First_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {
		
		
    	
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tops.class).buildSessionFactory();
    	
    	Session s = sf.openSession();
    	Transaction tx = s.beginTransaction();
    	Tops t = s.get(Tops.class, 1);
    	s.delete(t);
    	tx.commit();
		
	}
	
}
