package OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.buildSessionFactory();
		
		Category c = new Category();
		c.setCategory("Clothes");
		
		Product p1 = new Product();
		p1.setProduct("Pant");
		p1.setCategory(c);
		
		Product p2 = new Product();
		p2.setProduct("T-Shirts");
		p2.setCategory(c);

		List<Product> list = new ArrayList<Product>();
		list.add(p1);
		list.add(p2);
		
		c.setProduct(list);
		
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
//		s.save(c);
		
//		s.delete(s.get(Category.class, 2));
		
		List<Category> cl = s.createQuery("from Category").list();
		
		for (Category category : cl) {
			System.out.println(category.getCategory());
			for (Product pl : category.getProduct()) {
				System.out.println(pl.getProduct());
			}
			System.out.println("*********************");
		}
		
		tx.commit();
		
	}
	
}
