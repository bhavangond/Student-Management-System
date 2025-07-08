package com.Bhavan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhavan.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long> {

	Admin findByEmail(String email);

}
