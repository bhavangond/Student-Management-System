package com.Bhavan.Entity;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LeaveRequest {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Student student;

    @Column(nullable=false)
    private String reason;

    @Column(nullable=false)
    private LocalDate fromDate;
    
    @Column(nullable=false)
    private LocalDate toDate;

    private String status; // PENDING, APPROVED, REJECTED

    
}
