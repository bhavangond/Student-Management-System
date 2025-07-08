package com.Bhavan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhavan.Entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByStudentId(Long studentId);
}