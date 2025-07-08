package com.Bhavan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Bhavan.Dto.LeaveRequestDto;
import com.Bhavan.Entity.LeaveRequest;
import com.Bhavan.Service.LeaveRequestService;
import java.util.List;
@RestController
@RequestMapping("/api/leave")
@CrossOrigin(origins = "http://localhost:3000")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveService;

    @PostMapping("/submit/{Id}")
    public ResponseEntity<LeaveRequest> submit(@PathVariable Long Id,@RequestBody LeaveRequestDto dto) {
        return ResponseEntity.ok(leaveService.submitRequest(dto,Id));
    }

    
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<LeaveRequest>> getStudentRequests(@PathVariable Long studentId) {
        return ResponseEntity.ok(leaveService.getStudentRequests(studentId));
    }


    @GetMapping("/admin/all")
    public ResponseEntity<List<LeaveRequest>> getAllRequests() {
        return ResponseEntity.ok(leaveService.getAllRequests());
    }

    
    @PutMapping("/admin/update-status/{id}")
    public ResponseEntity<LeaveRequest> updateStatus(
        @PathVariable Long id,
        @RequestParam String status) {
        return ResponseEntity.ok(leaveService.updateStatus(id, status));
    }
}
