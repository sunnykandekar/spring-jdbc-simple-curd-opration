package com.spring.jdbc.springjdbc.Dao;

import java.util.List;

import com.spring.jdbc.Beans.Student;

public interface StudentDao                      // it is Parent class of (StudentDaoImple)
{
	  public int insert(Student student);         // insert mdt created it is an Abstract mtd (doesnt have method body)
	  public int update(Student student);        // update mtd
	  public int delete(int id);            // delete mtd
	  public Student select(int id);        // select mtd here getting Student obj 
	  public List<Student> getAllStudent(); 
	  

}
