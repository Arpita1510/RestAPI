package com.Arpita.Service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Arpita.BusinessObject.Student;
import com.Arpita.DataAccessObject.StudentDAO;
import com.Arpita.EntityObject.StudentEO;

@Component
public class StudentService {
	
	 private static final Logger logger = LogManager.getLogger(StudentService.class);
	
	  @Autowired
	  private StudentDAO studentDAO;
	  
	  StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
	  
	  //Add new Student records
	  public Student addStudent(Student student){
		studentDAO.save(studentMapper.studentTOStudentEO(student));
		
		if (logger.isDebugEnabled()) {
			logger.debug("Student Added");
		}
		
		return student ;
	  }
	  
	  //Fetch all student records
	  public List<Student> viewStudent() {
		List<StudentEO> studentEOList = studentDAO.findAll();
		List<Student> studentList = new ArrayList<Student>();
		if(studentEOList != null && !studentEOList.isEmpty()) {
			for(StudentEO studentEO : studentEOList){
				studentList.add(studentMapper.studentEOTOStudent(studentEO));
			}
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Student List" + studentList);
		}
		
		return studentList;
	  }
	  
	  //Fetch a student records with Student Id
	  public Student viewStudentById(int id) {
		StudentEO studentEO = studentDAO.findById(id); 
		return (studentMapper.studentEOTOStudent(studentEO));
	  }
	  
	  //Fetch all student records for a particular class
	  public List<Student> viewStudentForAClass(int standard) {
		List<StudentEO> studentEOList = studentDAO.findByStandard(standard); 
		List<Student> studentList = new ArrayList<Student>();
		if(studentEOList != null && !studentEOList.isEmpty()) {
			for(StudentEO studentEO : studentEOList){
				studentList.add(studentMapper.studentEOTOStudent(studentEO));
			}
		}
		return studentList;
	  }
	  
	  //Calculate average age of all students
	  public int getAverageAgeOfStudent() {
		  int avgAge = 0;
		  int totalAge = 0;
		  List<Student> studentList = viewStudent(); 
		  for(Student student : studentList) {
			  totalAge = totalAge + student.getAge();
		  }
		  avgAge = studentList.size() > 0 ? totalAge/studentList.size() : avgAge;
		  
		  if (logger.isDebugEnabled()) {
				logger.debug("Student Avg Age" + avgAge);
		  }
		  return avgAge;
	  }
	  
	  //Calculate maximum age of all students
	  public int getMaxAgeOfstudent() {
		  int maxAge = 0;
		  List<Student> studentList = viewStudent();
		  
		  if(studentList != null && !studentList.isEmpty()) {
			  for(Student student : studentList) {
				  if(maxAge < student.getAge()) {
					  maxAge = student.getAge();
				  }
			  }
		  }
		  if (logger.isDebugEnabled()) {
				logger.debug("Student Max Age" + maxAge);
		  }
		  
		  return maxAge;
	  }
	  
	  //Calculate minimum age of all students
	  public int getMinAgeOfstudent() {
		  int minAge = 0;
		  List<Student> studentList = viewStudent(); 
		  
		  if(studentList != null && !studentList.isEmpty()) {
			  for(Student student : studentList) {
				  if(minAge == 0 || minAge > student.getAge()) {
					  minAge = student.getAge();
				  }
			  }
		  }
		  if (logger.isDebugEnabled()) {
				logger.debug("Student Min Age" + minAge);
		  }
		  return minAge;
	  }
	  
}
