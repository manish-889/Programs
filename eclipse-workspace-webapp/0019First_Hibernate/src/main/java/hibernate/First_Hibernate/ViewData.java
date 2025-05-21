package hibernate.First_Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ViewData {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tops.class)
				.buildSessionFactory();

		Session s = sf.openSession();
		
		
		List<Tops> t = s.createQuery("from Tops").list();

		for ( Tops tp : t) {
			System.out.println(tp.getName());
		}
		
	}

}
