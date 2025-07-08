package com.Bhavan.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Bhavan.Dto.ComplaintDto;
import com.Bhavan.Entity.Complaint;
import com.Bhavan.Service.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin(origins = "http://localhost:3000")

public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Student submits complaint
    @PostMapping("/submit/{studentId}")
    public ResponseEntity<Complaint> submit(
        @PathVariable Long studentId,
        @RequestBody ComplaintDto dto) {
        return ResponseEntity.ok(complaintService.submitComplaint(studentId, dto));
    }

    // Student views their complaints
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Complaint>> studentComplaints(@PathVariable Long studentId) {
        return ResponseEntity.ok(complaintService.getStudentComplaints(studentId));
    }

    // Admin views all complaints
    @GetMapping("/admin/all")
    public ResponseEntity<List<Complaint>> allComplaints() {
        return ResponseEntity.ok(complaintService.getAllComplaints());
    }

    // Admin updates complaint status
    @PutMapping("/admin/update-status/{id}")
    public ResponseEntity<Complaint> updateStatus(
        @PathVariable Long id,
        @RequestParam String status) {
        return ResponseEntity.ok(complaintService.updateStatus(id, status));
    }
}

