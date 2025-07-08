package com.Bhavan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Bhavan.Entity.Admin;
import com.Bhavan.Repository.AdminRepository;
import com.Bhavan.Repository.StudentRepository;

@Service
public class AdminService {
	 @Autowired
	    private AdminRepository adminRepo;
	 	StudentRepository studentRepo;
	 	
	    public Admin login(String email, String password) {
	        Admin admin = adminRepo.findByEmail(email);
	        if (admin != null && admin.getPassword().equals(password)) {
	            return admin;
	        }
	        return null;
	    }
	    
	    
}
