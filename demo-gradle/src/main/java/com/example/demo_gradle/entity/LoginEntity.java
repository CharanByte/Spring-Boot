package com.example.demo_gradle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoginEntity {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String email;
}
