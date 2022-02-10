package com.Arpita.StudentDAOTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.Arpita.StudentBO.Student;
import com.Arpita.StudentDAO.StudentDAO;


@DataJpaTest
public class StudentDAOTest {
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Test
	public void addnewStudent() {
		
		Student student = new Student("Arpita" , 11, "Kolkata" , 8 , "C");
		studentDAO.save(student);
		Assertions.assertThat(student.getId()).isGreaterThan(0);
		
	}
	
	@BeforeEach
	public void addStudent() {
		
		Student student = new Student("Riya" , 12, "Kolkata" , 8 , "C");
		studentDAO.save(student);
	}
	
	@Test
	public void viewStudent() {
		
		Student student1 = studentDAO.findById(1);
		Assertions.assertThat(student1.getId()).isEqualTo(1);
		
	}

}
