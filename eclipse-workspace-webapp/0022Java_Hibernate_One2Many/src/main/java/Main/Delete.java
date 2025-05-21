package Main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Category;
import Model.Product;



public class Delete {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		s.delete(s.load(Category.class, 1));
		
		tx.commit();
		
	}
	
}
