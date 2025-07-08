package com.Bhavan.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Admin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String password;
}
