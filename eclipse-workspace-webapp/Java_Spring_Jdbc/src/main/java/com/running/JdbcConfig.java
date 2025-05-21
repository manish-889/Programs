package com.running;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.SpringDao.StudentDao;
import com.SpringDao.StudentDaoImp;

@Configuration
@ComponentScan(basePackages = {"com.SpringDao"})
public class JdbcConfig {

	@Bean
	public DataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springJdbc");
		ds.setUsername("root");
		ds.setPassword("manishgiri");
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate getTemplate() {
		
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		
		return jt;
	}
	
//	@Bean(name = "studentDao")
//	public StudentDao stDao() {
//		
//		StudentDaoImp stIm = new StudentDaoImp();
//		stIm.setJtemp(getTemplate());
//		
//		return stIm;
//	}
}
