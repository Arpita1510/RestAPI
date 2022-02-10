package com.Arpita.BO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	int standard;
	double fees;
	String teacherName;
	
	public Course() {
		
	}
	
	public Course(int id, String name, int standard,double fees, String teacherName) {
		super();
		this.id = id;
		this.name = name;
		this.standard = standard;
		this.fees = fees;
		this.teacherName = teacherName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", standard=" + standard + ", fees=" + fees + ", teacherName="
				+ teacherName + "]";
	}
}
