package com.Bhavan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhavan.Entity.Student;

public interface StudentRepository extends JpaRepository<Student,Long>{

	Student findByEmail(String email);
	
	
}
