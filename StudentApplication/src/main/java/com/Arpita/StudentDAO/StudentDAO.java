package com.Arpita.StudentDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Arpita.StudentBO.Student;

//@Repository
public interface StudentDAO extends JpaRepository<Student, Integer>{

	List<Student> findByStandard(int standard);
	Student findById(int id);
}
