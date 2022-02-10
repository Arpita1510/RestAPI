package com.Arpita.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arpita.BO.Course;

public interface CourseDAO extends JpaRepository<Course, Integer> {

	Course findById(int id);
	Course findByStandard(int id);
	
}
