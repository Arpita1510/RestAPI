package com.Arpita.Service;


import org.mapstruct.Mapper;

import com.Arpita.BusinessObject.Student;
import com.Arpita.EntityObject.StudentEO;

@Mapper(componentModel = "spring")
public interface StudentMapper {
	
	StudentEO studentTOStudentEO(Student student);
	Student studentEOTOStudent(StudentEO student);
}
