package com.Arpita.BO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CoachingCentre {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	int courseId;
	String address;
	
	public CoachingCentre() {
	}

	public CoachingCentre(int id, String name, int courseId, String address) {
		super();
		this.id = id;
		this.name = name;
		this.courseId = courseId;
		this.address = address;
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
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CoachingCentre [id=" + id + ", name=" + name + ", courseId=" + courseId + ", address=" + address + "]";
	}
	

}
