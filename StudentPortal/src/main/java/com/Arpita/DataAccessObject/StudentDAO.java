package com.Arpita.DataAccessObject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Arpita.EntityObject.StudentEO;

public interface StudentDAO extends JpaRepository<StudentEO, Integer>{

	List<StudentEO> findByStandard(int standard);
	StudentEO findById(int id);
}
