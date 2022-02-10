package com.Arpita.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Arpita.StudentBO.Course;
import com.Arpita.StudentBO.RestTemplateBO;
import com.Arpita.StudentBO.Student;
import com.Arpita.StudentDAO.StudentDAO;


@Service
public class StudentService {
	
	  @Autowired
	  private StudentDAO studentDAO;
	  
	  @Autowired
	  private RestTemplate restTemplate;
	  
	  //Add new Student records
	  public Student addStudent(Student student){
		studentDAO.save(student);
		return student;
	  }
	  
	  //Fetch all student records
	  public List<Student> viewStudent() {
		List<Student> studentList = studentDAO.findAll();
		return studentList;
	  }
	  
	  //Fetch a student records with Student Id
	  public RestTemplateBO viewStudentById(int id) {
		Student student = studentDAO.findById(id); 
		
		RestTemplateBO studDetails = new RestTemplateBO();
		
		Course course = restTemplate.getForObject("http://localhost:9001/viewCourse/class/" +student.getStandard() , Course.class);
		
		studDetails.setStudent(student);
		studDetails.setCourse(course);
		
		return studDetails;
	  }
	  
	  //Fetch all student and course records
	  public List<RestTemplateBO> viewStudentCourse() {
		List<Student> studentList = studentDAO.findAll();
		
		List<RestTemplateBO> studentCourseList = new ArrayList<RestTemplateBO>();
		
		for(Student student : studentList) {
			RestTemplateBO studDetails = new RestTemplateBO();
			
			Course course = restTemplate.getForObject("http://localhost:9001/viewCourse/class/" +student.getStandard() , Course.class) ;
			studDetails.setStudent(student);
			studDetails.setCourse(course);
			studentCourseList.add(studDetails);
		}
		return studentCourseList;
	  }
	  
	  //Fetch all course records
	  public Object viewCourseList() {
		
		Object course = restTemplate.getForObject("http://localhost:9001/viewCourse/1", Course.class);

		return course;
	  }
	  
	  //Fetch all student records for a particular class
	  public List<Student> viewStudentForAClass(int standard) {
		List<Student> studentList = studentDAO.findByStandard(standard); 
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
		  avgAge = totalAge/studentList.size();
		  
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
		  return minAge;
	  }

	public Object getCourseMsg() {
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		Object courseMsg = restTemplate.exchange("http://localhost:9001/course/", HttpMethod.GET, entity, String.class).getBody();//getForObject("http://localhost:9001/course/", Course.class);
		return courseMsg;
	}
	  
}
