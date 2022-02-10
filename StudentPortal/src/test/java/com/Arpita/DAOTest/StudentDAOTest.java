package com.Arpita.DAOTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.Arpita.BusinessObject.Student;
import com.Arpita.DataAccessObject.StudentDAO;
import com.Arpita.EntityObject.StudentEO;
import com.Arpita.Service.StudentMapper;


@DataJpaTest
public class StudentDAOTest {
	
	  
	  @Autowired 
	  private StudentDAO studentDAO;
	  
	  @Test 
	  public void addNewStudent() {
	  
	  StudentEO student = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
	  studentDAO.save(student);
	  Assertions.assertThat(student.getId()).isGreaterThan(0); }
	  
	  
	  @BeforeEach 
	  public void addStudent() {
	  
	  StudentEO student = new StudentEO(2, "Riya" , 12, "Kolkata" , 8 , "C");
	  studentDAO.save(student); }
	  
	  @Test 
	  public void viewStudent() {
	  
	  StudentEO student = studentDAO.findById(1);
	  Assertions.assertThat(student.getId()).isEqualTo(1);
	  
	  }
	  
	 }
