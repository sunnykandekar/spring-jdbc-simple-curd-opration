package com.spring.jdbc.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Beans.Student;
import com.spring.jdbc.springjdbc.Dao.StudentDao;

public class App 
{
    public static void main( String[] args )
    {
        //ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/springjdbc/configJdbc.xml");
        
        ApplicationContext context= new AnnotationConfigApplicationContext(configJdbc.class);
        
           //JdbcTemplate template= context.getBean("bnJdbcTemplate",JdbcTemplate.class);  // spring JdbcTemplate
           
           /*
             // simple mtd 1 insert
            String query="insert into table7(id,name,city)values(?,?,?)";        // 
          
            // execute/fire queries...
            int result = template.update(query,102,"Er.sunny","Pune");
            System.out.println("number of record inserted : "+result); 
        */
   //.................................................................................................................................        
        
        // inserted using Dao Interface Mtd 2
        
     // here obj created of StudentDao Bean of xml (getting bean) & we store child class(imple) in Parent class(StudentDao).
        //StudentDao stdao1= context.getBean("bnStudentDao",StudentDao.class); 
        StudentDao stdao1= context.getBean("studentDao",StudentDao.class); 
        
        
       /*    
     // bean obj 1 created
        Student st=new Student();    
        // setting val
        st.setId(106);                    
        st.setName("Er.Sunny6");
        st.setCity("Pune");
        
        int result = stdao1.insert(st);        // here we store bean (st)obj in object(stdao1) of StudentDao.class & execute mtd
        System.out.println("Student Record inserted : "+result);     // display result...
        
        
     // bean obj 2 created
        Student st1=new Student();      
        // setting val
        st1.setId(107);                   
        st1.setName("Er.Sunny7");
        st1.setCity("Pune");
        
        int result1 = stdao1.insert(st1);
        System.out.println("Student Record inserted : "+result1);
        */
        
        
 //... ......................................................................................................  
     /*   // update query
        
        Student st=new Student();
        st.setId(102);
        st.setName("Engineer Sunny");
        st.setCity("Georai");
        
        int result = stdao1.update(st);
        System.out.println("Record Updated : "+result );
      */
 //.............................................................................................................
         /* // delete
        int result = stdao1.delete(105);
        System.out.println("Record Deleted : "+result);*/
//.............................................................................................................
        /*// select data for single user
        Student student = stdao1.select(101);
        System.out.println("Record Selected : "+student);
        */
//........................................................................................................................
        // select allStudent records
        List<Student> list = stdao1.getAllStudent();            // list obj created 
        for(Student s :list)
        { 
        	System.out.println(s);
        }
        System.out.println("retrived Data Successfully..!");
    }
}



















