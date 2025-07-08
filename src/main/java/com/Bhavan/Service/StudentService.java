package com.Bhavan.Service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhavan.Entity.Student;
import com.Bhavan.Repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	public Student login(String email, String password) {
        Student student = studentRepo.findByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }
	
	
	 public Student register(Student student) {
	        return studentRepo.save(student);
	    }

	    public Student updateStudent(Long id, Student newStudent) {
	        Student student = studentRepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
	        student.setName(newStudent.getName());
	        student.setEmail(newStudent.getEmail());
	        student.setRoomNo(newStudent.getRoomNo());
	        student.setPhone(newStudent.getPhone());
	        return studentRepo.save(student);
	    }

	    public void deleteStudent(Long id) {
	        studentRepo.deleteById(id);
	    }
	    
	    public List<Student> findAll(){
	    	return studentRepo.findAll();
	    }
	}
