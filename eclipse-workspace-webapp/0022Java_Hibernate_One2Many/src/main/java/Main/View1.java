package Main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Category;
import Model.Product;


public class View1 {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
	
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		List<Category> list = s.createQuery("from Category").list();
		
		for (Category c : list) {
			System.out.println(c.getCategory());
			for (Product p : c.getProduct()) {
				System.out.println(p.getProducts());
			}
			System.out.println("******************************");
		}
		
		
		tx.commit();
		
	}
	
}
