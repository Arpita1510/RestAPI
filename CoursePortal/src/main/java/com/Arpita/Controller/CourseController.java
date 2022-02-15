package com.Arpita.Controller;

import java.util.List;

import javax.persistence.PostLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arpita.BO.Course;
import com.Arpita.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping("/addCourse/")
	public String addCourse(@RequestBody Course course) {
		
		Course addedCourse = courseService.addCourse(course);
		
		if(addedCourse != null) {
			return "Course added";
		}else {
			return "Course not added";
		}
		
	}
	
	@GetMapping("/viewCourse/")
	public List<Course> viewCourseList(){
		
		return courseService.viewCourse();
		
	}
	
	@GetMapping("/viewCourse/{id}")
	public Course getCourseById(@PathVariable int id) {
		
		return courseService.getACourse(id);
	}
	
	@GetMapping("/viewCourse/class/{id}")
	public Course getCourseByStandard(@PathVariable int id) {
		
		return courseService.getCourseByStandard(id);
	}
	
	@GetMapping("/courseMsg/")
	public String getCourseMsg() {
		return "Welcome To Course Portal";
	}

}
