package com.Arpita.StudentController;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Arpita.StudentBO.Course;
import com.Arpita.StudentBO.RestTemplateBO;
import com.Arpita.StudentBO.Student;
import com.Arpita.StudentService.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@Validated
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//Add a new student
	@PostMapping("/addStudent/")
	public ResponseEntity<Void> addStudent(@RequestBody Student student) {
		
		Student newStudent = studentService.addStudent(student);
		if(newStudent == null) {
			return ResponseEntity.noContent().build();
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(newStudent.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	//Fetch all students
	@GetMapping("/viewStudent/")
	public List<Student> getStudentList() {
		return studentService.viewStudent();
	}
	
	//Fetch students from student id
	@GetMapping("/viewStudent/{id}/")
	public RestTemplateBO getStudentList(@PathVariable @NotNull @Min(1) int id) {
		return studentService.viewStudentById(id);
	}
		
	//Fetch all students & corresponding course
	@GetMapping("/viewStudentCourse/")
	public List<RestTemplateBO> getStudentCourseList() {
		return studentService.viewStudentCourse();
	}
	
	//Fetch all course
	@GetMapping("/viewCourse/1")
	public Object getCourseList() {
		return studentService.viewCourseList();
	}
	
	//Fetch all course
	@GetMapping("/course/")
	public Object getCourseMsg() {
		return studentService.getCourseMsg();
	}
		
	//Fetch students of a particular class using min & max annotation for validation
	@GetMapping("/viewStudent/class/{standard}/")
	public List<Student> getStudentListForAClass(@PathVariable @NotNull @Min(1) @Max(12) int standard) {
		return studentService.viewStudentForAClass(standard);
	}
	
	//Fetch average age of all students
	@GetMapping("/avgAge/")
	public int getStudentAvgAge() {
		return studentService.getAverageAgeOfStudent();
	}
	
	//Fetch maximum age of all students
	@GetMapping("/maxAge/")
	public int getStudentMaxAge() {
		return studentService.getMaxAgeOfstudent();
	}
	
	//Fetch minimum age of all students
	@GetMapping("/minAge/")
	public int getStudentMinAge() {
		return studentService.getMinAgeOfstudent();
	}
}
