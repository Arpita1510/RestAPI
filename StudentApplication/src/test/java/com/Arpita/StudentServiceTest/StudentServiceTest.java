package com.Arpita.StudentServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Arpita.StudentBO.Student;
import com.Arpita.StudentDAO.StudentDAO;
import com.Arpita.StudentService.StudentService;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentDAO studentDAO;
	
	/* Student List dummy
	{
	  "name": "Arpita",
	  "age":"11",
	  "address": "Kolkata",
	  "standard":"8",
	  "section": "C"
	}
	{
	  "name": "Riya",
	  "age":"13",
	  "address": "Delhi",
	  "standard":"8",
	  "section": "B"
	}
	{
	  "name": "Avik",
	  "age":"16",
	  "address": "Kolkata",
	  "standard":"10",
	  "section": "A"
	}
	 */
	
	
	@Test
	public void addStudent() {
		
		Student mockStudent = new Student(1,"Arpita" , 11, "Kolkata" , 8 , "C");
		Mockito.when(studentDAO.save(Mockito.any(Student.class))).thenReturn(mockStudent);
		
		assertThat(studentService.addStudent(mockStudent)).isEqualTo(mockStudent);
	}
	
	@Test
	public void getStudentAverageAge() {
		
		int expectedAvgAge = 13;
		
		Student student1 = new Student(1,"Arpita" , 11, "Kolkata" , 8 , "C");
		Student student2 = new Student(2,"Riya" , 13, "Delhi" , 8 , "B");
		Student student3 = new Student(3,"Arpita" , 16, "Kolkata" , 10 , "A");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		Mockito.when(studentDAO.findAll()).thenReturn(studentList);
		
		int avgAge = studentService.getAverageAgeOfStudent();
		assertEquals(expectedAvgAge, avgAge);
		
	}
	
	@Test
	public void getStudentMaxAge() {
		
		int expectedMaxAge = 16;
		
		Student student1 = new Student(1,"Arpita" , 11, "Kolkata" , 8 , "C");
		Student student2 = new Student(2,"Riya" , 13, "Delhi" , 8 , "B");
		Student student3 = new Student(3,"Arpita" , 16, "Kolkata" , 10 , "A");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		Mockito.when(studentDAO.findAll()).thenReturn(studentList);
		
		int maxAge = studentService.getMaxAgeOfstudent();
		assertEquals(expectedMaxAge, maxAge);
		
	}
	
	@Test
	public void getStudentMinAge() {
		
		int expectedMinAge = 11;
		
		Student student1 = new Student(1,"Arpita" , 11, "Kolkata" , 8 , "C");
		Student student2 = new Student(2,"Riya" , 13, "Delhi" , 8 , "B");
		Student student3 = new Student(3,"Arpita" , 16, "Kolkata" , 10 , "A");
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		Mockito.when(studentDAO.findAll()).thenReturn(studentList);
		
		int minAge = studentService.getMinAgeOfstudent();
		assertEquals(expectedMinAge, minAge);
		
	}

}
