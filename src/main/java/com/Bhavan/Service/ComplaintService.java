package com.Bhavan.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.Bhavan.Dto.ComplaintDto;
import com.Bhavan.Entity.Complaint;
import com.Bhavan.Entity.Student;
import com.Bhavan.Repository.ComplaintRepository;
import com.Bhavan.Repository.StudentRepository;

@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepo;

    @Autowired
    private StudentRepository studentRepo;

    public Complaint submitComplaint(Long studentId, ComplaintDto dto) {
        Student student = studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("Student not found"));
        Complaint complaint=new Complaint();
        complaint.setStudent(student);
        complaint.setStatus("PENDING");
        complaint.setCreatedAt(LocalDateTime.now());
        complaint.setTitle(dto.getTitle());
        complaint.setDescription(dto.getDescription());
        return complaintRepo.save(complaint);
    }

    public List<Complaint> getStudentComplaints(Long studentId) {
        return complaintRepo.findByStudentId(studentId);
    }

    public List<Complaint> getAllComplaints() {
        return complaintRepo.findAll();
    }

    public Complaint updateStatus(Long id, String status) {
        Complaint complaint = complaintRepo.findById(id).orElseThrow(() -> new RuntimeException("Complaint not found"));
        complaint.setStatus(status.toUpperCase());
        return complaintRepo.save(complaint);
    }
}

