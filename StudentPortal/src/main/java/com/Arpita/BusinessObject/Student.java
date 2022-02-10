package com.Arpita.BusinessObject;

import javax.persistence.Id;

public class Student {
	
	@Id
	private int id;
	private String name;
	private int age;
	private String address;
	private int standard;
	private String section;
	
	
	public Student() {
	}

	public Student(int id, String name, int age, String address, int standard, String section) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.standard = standard;
		this.section = section;
	}
	
	public Student(String name, int age, String address, int standard, String section) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.standard = standard;
		this.section = section;
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
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ",age=" + age + ", address=" + address + ", standard=" + standard + ", section="
				+ section + "]";
	}

}
