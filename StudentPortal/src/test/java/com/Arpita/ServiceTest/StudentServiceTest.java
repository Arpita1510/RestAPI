package com.Arpita.ServiceTest;
  
import static org.junit.jupiter.api.Assertions.assertEquals;
  
import java.util.ArrayList; import java.util.List;
  
import org.junit.jupiter.api.Test;
import org.mockito.Mockito; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.boot.test.context.SpringBootTest; 
import org.springframework.boot.test.mock.mockito.MockBean;

import com.Arpita.DataAccessObject.StudentDAO;  
import com.Arpita.EntityObject.StudentEO; 
import com.Arpita.Service.StudentMapper;
import com.Arpita.Service.StudentService;
  
@SpringBootTest 
public class StudentServiceTest {
  
  @Autowired 
  private StudentService studentService;
  
  @Autowired 
  private StudentMapper studentMapper;
  
  @MockBean 
  private StudentDAO studentDAO;
  
  /*Student List dummy { "name": "Arpita", "age":"11", "address": "Kolkata",
  "standard":"8", "section": "C" } { "name": "Riya", "age":"13", "address":
  "Delhi", "standard":"8", "section": "B" } { "name": "Avik", "age":"16",
  "address": "Kolkata", "standard":"10", "section": "A" }*/
  
  
  @Test 
  public void addStudent() {
  
  StudentEO mockStudent = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
  Mockito.when(studentDAO.save(Mockito.any(StudentEO.class))).thenReturn(mockStudent);
  
  assertEquals(studentService.addStudent(studentMapper.studentEOTOStudent(mockStudent)).getId(),studentMapper.studentEOTOStudent(mockStudent).getId());
  }
  
  @Test 
  public void getStudentAverageAge() {
  
  int expectedAvgAge = 13;
  
  StudentEO student1 = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
  StudentEO student2 = new StudentEO(2,"Riya" , 13, "Delhi" , 8 , "B");
  StudentEO student3 = new StudentEO(3,"Arpita" , 16, "Kolkata" , 10 , "A");
  List<StudentEO> studentList = new ArrayList<StudentEO>();
  studentList.add(student1); studentList.add(student2);
  studentList.add(student3);
  
  Mockito.when(studentDAO.findAll()).thenReturn(studentList);
  
  int avgAge = studentService.getAverageAgeOfStudent();
  assertEquals(expectedAvgAge, avgAge);
  
  }
  
  @Test 
  public void getStudentMaxAge() {
  
  int expectedMaxAge = 16;
  
  StudentEO student1 = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
  StudentEO student2 = new StudentEO(2,"Riya" , 13, "Delhi" , 8 , "B");
  StudentEO student3 = new StudentEO(3,"Arpita" , 16, "Kolkata" , 10 , "A");
  List<StudentEO> studentList = new ArrayList<StudentEO>();
  studentList.add(student1); studentList.add(student2);
  studentList.add(student3);
  
  Mockito.when(studentDAO.findAll()).thenReturn(studentList);
  
  int maxAge = studentService.getMaxAgeOfstudent();
  assertEquals(expectedMaxAge, maxAge);
  
  }
  
  @Test 
  public void getStudentMinAge() {
  
  int expectedMinAge = 11;
  
  StudentEO student1 = new StudentEO(1,"Arpita" , 11, "Kolkata" , 8 , "C");
  StudentEO student2 = new StudentEO(2,"Riya" , 13, "Delhi" , 8 , "B");
  StudentEO student3 = new StudentEO(3,"Arpita" , 16, "Kolkata" , 10 , "A");
  List<StudentEO> studentList = new ArrayList<StudentEO>();
  studentList.add(student1); studentList.add(student2);
  studentList.add(student3);
  
  Mockito.when(studentDAO.findAll()).thenReturn(studentList);
  
  int minAge = studentService.getMinAgeOfstudent();
  assertEquals(expectedMinAge, minAge);
  
  }
}
