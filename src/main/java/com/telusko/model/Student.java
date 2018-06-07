package com.telusko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="rk_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(length = 11, nullable = false)
	private int age;

	@Column(length = 30, nullable = false)
	private String marks;

	@Column(length = 30, nullable = false)
	private String city;

	public Student() {}

	public Student(Integer id, String name, int age, String marks, String city) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
