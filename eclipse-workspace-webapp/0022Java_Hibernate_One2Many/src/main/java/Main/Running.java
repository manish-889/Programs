package Main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.Category;
import Model.Product;


public class Running {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		
		Category c = new Category();
		c.setCategory("Sports");
		
		
		Product p = new Product();
		p.setProducts("Ball");
		p.setCategory(c);
		
		Product p1 = new Product();
		p1.setProducts("Bat");
		p1.setCategory(c);
		
		Product p2 = new Product();
		p2.setProducts("Helment");
		p2.setCategory(c);
		
		List<Product> list = new  ArrayList<Product>();
		list.add(p1);
		list.add(p);
		list.add(p2);
		c.setProduct(list);
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.save(c);
		tx.commit();
		
	}
	
}
