package com.Bhavan.Controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Bhavan.Dto.LoginDto;
import com.Bhavan.Entity.Student;
import com.Bhavan.Service.StudentService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")

public class StudentController {
		
	@Autowired
	StudentService studentService;
	
	 @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginDto login) {
	        Student student = studentService.login(login.getEmail(), login.getPassword());
	        if (student != null) {
	            return ResponseEntity.ok(student);
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
	 
	 @GetMapping("/all")
	 public ResponseEntity<List<Student>> allStudents() {
	     return ResponseEntity.ok(studentService.findAll());
	 }
	 
	 @PostMapping("/add-student")
	    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
	        return ResponseEntity.ok(studentService.register(student));
	    }

	    @PutMapping("/update-student/{id}")
	    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
	        return ResponseEntity.ok(studentService.updateStudent(id, student));
	    }

	    @DeleteMapping("/delete-student/{id}")
	    public ResponseEntity<?> delete(@PathVariable Long id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.ok("Student deleted successfully");
	    }
}
