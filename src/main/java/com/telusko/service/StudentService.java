package com.telusko.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.model.Student;
import com.telusko.repositorie.StudentRepositorie;

@Service
public class StudentService {

	@Autowired
	private StudentRepositorie studentRepositorie;

	public Student save(Student reqStudent) {
		return studentRepositorie.save(reqStudent);
	}

	public Iterable<Student> findAll() {
		return studentRepositorie.findAll();
	}

	public List<Object[]> findByAgeGroup(int start, int end) {
		return studentRepositorie.findByAgeBetweenQuery(start, end);
	}

	public List<Object[]> findByAgeGroup1(int start, int end) {
		return studentRepositorie.findByAgeBetweenQuery1(start, end);
	}
	
	public List<Object[]> findByAgeWithCityGroup(int start, int end, String city) {
		return studentRepositorie.findByAgeAndCityBetweenQuery(start, end, city);
	}

	public Object findCity() {
		return studentRepositorie.findByAllCity();
	}
}
