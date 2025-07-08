package com.Bhavan.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
    private String email;
    
    @Column(nullable=false)
    private String password;
    
    @Column(nullable=false)
    private String roomNo;
    
    @Column(nullable=false)
    private String phone;
}
