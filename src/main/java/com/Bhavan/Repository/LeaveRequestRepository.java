package com.Bhavan.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Bhavan.Entity.LeaveRequest;
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByStudentId(Long studentId);
}

