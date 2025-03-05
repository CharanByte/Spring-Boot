package com.example.demo_gradle.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "demo")
@Data
public class DemoEntity {

    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private int age;
    private String gender;

}
