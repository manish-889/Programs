package com.hiber;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
       SessionFactory factory = new Configuration().configure().buildSessionFactory();
       
       Student st = new Student();
       
       st.setId(2);
       st.setName("Hariom Tripathi");
       st.setCity("Surat");
       
       StudentAddress add = new StudentAddress();
       
       add.setStreet("Zadeshwar");
       add.setCity("Bharuch");
       add.setOpen(false);
       add.setX(45.5);
       add.setAddedDate(new Date());
       
       Session session = factory.openSession();
       
       Transaction tran = session.beginTransaction();
       
       session.save(st);
       session.save(add);
       
       tran.commit();
       
       session.close();
    }
}
