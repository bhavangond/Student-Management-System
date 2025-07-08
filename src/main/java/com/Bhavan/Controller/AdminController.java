package com.Bhavan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Bhavan.Dto.LoginDto;
import com.Bhavan.Entity.Admin;
import com.Bhavan.Entity.Student;
import com.Bhavan.Service.AdminService;
import com.Bhavan.Service.StudentService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")

public class AdminController {
	
	@Autowired
	StudentService studentService;
	  @Autowired
	    private AdminService adminService;

	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginDto login) {
	        Admin admin = adminService.login(login.getEmail(), login.getPassword());
	        if (admin != null) {
	            return ResponseEntity.ok("Admin login successful");
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
	    
	
}
