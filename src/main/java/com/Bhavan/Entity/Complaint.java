package com.Bhavan.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title; 

    @Column(nullable=false)
    private String description;

    private String status; // PENDING, RESOLVED, REJECTED

    private LocalDateTime createdAt;

    @ManyToOne
    private Student student;

    
}
