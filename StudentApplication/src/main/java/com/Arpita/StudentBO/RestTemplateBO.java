package com.Arpita.StudentBO;

public class RestTemplateBO {
	
	private Student student;
	private Course course;
	
	public RestTemplateBO() {
		
	}

	public RestTemplateBO(Student student , Course course) {
		super();
		this.student = student;
		this.course = course;
		
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	

}
