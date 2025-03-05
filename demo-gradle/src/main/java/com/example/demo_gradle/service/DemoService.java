package com.example.demo_gradle.service;

import com.example.demo_gradle.dto.DemoDTO;
import com.example.demo_gradle.entity.DemoEntity;

import java.util.Optional;

public interface DemoService {
    DemoEntity save(DemoDTO demoDTO);

    Optional<DemoEntity> getAllById(int id);



    void updateById(int id, String name, int age, String gender);

    void deleteById(int id);
}
