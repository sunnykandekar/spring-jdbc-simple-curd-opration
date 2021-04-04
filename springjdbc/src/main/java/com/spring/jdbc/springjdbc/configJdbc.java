 
// jdbc configuration without using xml, We used @Configuration annotation

package com.spring.jdbc.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.springjdbc.Dao.StudentDao;
import com.spring.jdbc.springjdbc.Dao.StudentDaoImple;

@Configuration
public class configJdbc 
{                                  // here we must be created 3 methods ie. bean objects
	
	@Bean(name= {"bnDS"})                              // so we can directly writen(ie.DataSource) parent class
     public DataSource getDataSource()               // or public DriverManagerDataSource getDataSource() ,its implementation class of DataSource
     {                                           
		                           // note: DriverManagerDataSource class extends AbstractDriverBasedDataSource class extends AbstractDataSource class implements DataSource interface(Available from javax.sql.DataSource pkg )   
		
		DriverManagerDataSource bnDS = new DriverManagerDataSource();  // obj created ,its used for following properties,availables in{DriverManagerDataSource()}    
		 
		bnDS.setDriverClassName("com.mysql.jdbc.Driver");
		bnDS.setUrl("jdbc:mysql://localhost:3306/sk");
		bnDS.setUsername("root");
		bnDS.setPassword("");
		
		return bnDS;
     }
	
	@Bean(name= {"bnJdbcTemplate"})
	public JdbcTemplate getTemplate()
	{
	  JdbcTemplate jdbcTemplate	= new JdbcTemplate();
	  jdbcTemplate.setDataSource(getDataSource());
	  
	  return jdbcTemplate;
	}
	
    @Bean(name= {"studentDao"})
	public StudentDao getStudentDao()
	  {
		StudentDaoImple studentDao =new StudentDaoImple();
		studentDao.setJdbcTemplate(getTemplate());
		
		return studentDao;		
    	}
	
}
























