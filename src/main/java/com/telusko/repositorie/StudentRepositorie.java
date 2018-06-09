package com.telusko.repositorie;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.telusko.model.Student;

public interface StudentRepositorie extends CrudRepository<Student,Integer>{
	
	//@Query("select rk from Student rk where rk.age >= ?1 and rk.age <= ?2")
	@Query("select rk.name,rk.age,rk.city, Avg(rk.marks) as marks from Student rk where rk.age >= ?1 and rk.age <= ?2 group by rk.id order by rk.marks DESC")
	List<Object[]> findByAgeBetweenQuery(@Param("start") int start, @Param("end") int end);
	
	@Query("select rk.name,rk.age,rk.city, Avg(rk.marks) as marks from Student rk where rk.age >= ?1 and rk.age <= ?2 and rk.city = ?3 group by rk.id order by rk.marks DESC")
	List<Object[]> findByAgeAndCityBetweenQuery(@Param("start") int start, @Param("end") int end,@Param("city") String city);
	
	@Query("select DISTINCT rk from Student rk")
	Iterable<Student> findByAllCity();
	
	@Query("select rk.name,rk.age,rk.city, Avg(rk.marks) as marks from Student rk where rk.age >= 10 and rk.age <= 30 group by rk.id order by rk.marks DESC")
	List<Object[]> findByAgeBetweenQuery1(@Param("start") int start, @Param("end") int end);
}
	