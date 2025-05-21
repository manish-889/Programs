package hibernate.First_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String[] args) {
		
		Tops t = new Tops();
    	t.setId(1);
    	t.setName("manish");
    	
    	SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tops.class).buildSessionFactory();
    	
    	Session s = sf.openSession();
    	Transaction tx = s.beginTransaction();
    	s.saveOrUpdate(t);
    	tx.commit();
		
	}
	
}
