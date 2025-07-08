package com.Bhavan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.Bhavan.Dto.LeaveRequestDto;
import com.Bhavan.Entity.LeaveRequest;
import com.Bhavan.Entity.Student;
import com.Bhavan.Repository.LeaveRequestRepository;
import com.Bhavan.Repository.StudentRepository;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRepo;
    @Autowired
    private StudentRepository studentRepo;
    public LeaveRequest submitRequest(LeaveRequestDto dto,Long studentId) {
    	Student student = studentRepo.findById(studentId).orElseThrow();
        LeaveRequest request = new LeaveRequest();
        request.setStudent(student);
        request.setReason(dto.getReason());
        request.setFromDate(dto.getFromDate());
        request.setToDate(dto.getToDate());
        request.setStatus("PENDING");
        return  leaveRepo.save(request);
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveRepo.findAll();
    }

    public List<LeaveRequest> getStudentRequests(Long studentId) {
        return leaveRepo.findByStudentId(studentId);
    }

    public LeaveRequest updateStatus(Long id, String status) {
        LeaveRequest req = leaveRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found"));
        req.setStatus(status.toUpperCase());
        return leaveRepo.save(req);
    }
}

