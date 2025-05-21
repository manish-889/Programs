package com.SpringJdbcSimple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Programe is started..." );
        
        ApplicationContext context = new ClassPathXmlApplicationContext("com/springJdbc/config.xml");
        //Spring JDBC => Spring Template
        JdbcTemplate temp = (JdbcTemplate) context.getBean("JdbcTemplate");
        
        //Query for insert
        String query = "INSERT INTO Student(id,name,city) VALUES (?,?,?) ";
        
        //Fire that query
        int result = temp.update(query,22,"Mansih", "Bahruch");
        
        System.out.println("Number of record inserted : "+result);
    }
}
