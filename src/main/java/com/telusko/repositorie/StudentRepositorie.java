package com.telusko.repositorie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.telusko.model.Student;

public interface StudentRepositorie extends CrudRepository<Student,Integer>{
	
	@Query("select rk from Student rk where rk.age >= ?1 and rk.age <= ?2 ORDER BY marks DESC")
	List<Student> findByAgeBetweenQuery(@Param("start") int start, @Param("end") int end);
	
	/*@Query("select DISTINCT rk.city from Student rk")
	Iterable<Student> findDistinctByAllCity();*/
	
	@Query("select DISTINCT rk from Student rk")
	Iterable<Student> findByAllCity();
}
	