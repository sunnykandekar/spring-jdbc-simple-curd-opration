package com.spring.jdbc.springjdbc.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Beans.Student;

public class rowMapperImple implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{ 
		// bean obj created
		Student st =new Student();      
		   st.setId(rs.getInt(1));
		   st.setName(rs.getString(2));
		   st.setCity(rs.getString(3));
		return st;
	}

}
