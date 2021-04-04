package com.spring.jdbc.springjdbc.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Beans.Student;

public class StudentDaoImple implements StudentDao             // it is child class of (StudentDao)

{
     private JdbcTemplate jdbcTemplate;    // creating new properties
     
          // setter getter
       public JdbcTemplate getJdbcTemplate() 
        {
         return jdbcTemplate;
        }

      public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
       {
         this.jdbcTemplate = jdbcTemplate;
       }
                           
                               // and Methods implemented here
	public int insert(Student student)             //insert implemented here
	{  
		 //insert query...
		String query="insert into table7(id,name,city)values(?,?,?)";
		int rs = this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return rs;
	}

	public int update(Student student) 
	{
		// update query...
		String query="update table7 set name=?, city=? where id=?";
		int rs = this.jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
		return rs;
	}

	public int delete(int id) 
	{ 
		  // delete query...
	     String query="delete from table7 where id=?";
	     int rs = this.jdbcTemplate.update(query,id);
		return rs;
	}

	public Student select(int id) 
	{
	      // select query for single student data 
		  String query="select * from table7 where id=? ";
		  RowMapper<Student> rowMapper = new rowMapperImple();
		  Student student = this.jdbcTemplate.queryForObject(query, rowMapper,id);
		  
		return student;
	}

	public List<Student> getAllStudent() 
	{
	      // select/get  AllStudent records	
		String query="select * from table7";
		List<Student> list = this.jdbcTemplate.query(query, new rowMapperImple());
		return list;
	}
 

}





















