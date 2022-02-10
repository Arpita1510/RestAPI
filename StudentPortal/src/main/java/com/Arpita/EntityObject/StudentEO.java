package com.Arpita.EntityObject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // Entity class related with table
@Table(name = "Student")
public class StudentEO {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Size(min= 1, max=10)
	private String name;
	
	private int age;
	private String address;
	private int standard;
	private String section;
	
	
	public StudentEO() {
	}

	public StudentEO(int id, String name, int age, String address, int standard, String section) {
		super();
		this.id = id;
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
