package com.Arpita.Controller;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Arpita.BusinessObject.Student;
import com.Arpita.Service.StudentService;


@RestController
@Validated
public class StudentController {
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	
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
		
		if (logger.isDebugEnabled()) {
			logger.debug("Student Added Sucesfully");
		}

		return ResponseEntity.created(location).build();
	}

	//Fetch all students
	@GetMapping("/viewStudent/")
	public List<Student> getStudentList() {
		return studentService.viewStudent();
	}
	
	//Fetch students from student id
	@GetMapping("/viewStudent/{id}/")
	public Student getStudentList(@PathVariable @NotNull @Min(1) int id) {
		return studentService.viewStudentById(id);
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
