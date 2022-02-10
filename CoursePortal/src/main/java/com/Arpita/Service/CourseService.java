package com.Arpita.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Arpita.BO.Course;
import com.Arpita.DAO.CourseDAO;

@Component
public class CourseService {
	
	@Autowired
	private CourseDAO courseDAO;
	
	public Course addCourse(Course course) {
		return courseDAO.save(course);
	}

	public List<Course> viewCourse(){
		
		List<Course> courseList = courseDAO.findAll();
		return courseList;
	}
	
	public Course getACourse(int id) {
		
		Course course = courseDAO.findById(id);
		return course;
	}
	
	public Course getCourseByStandard(int id) {
		
		Course course = courseDAO.findByStandard(id);
		return course;
	}
}
