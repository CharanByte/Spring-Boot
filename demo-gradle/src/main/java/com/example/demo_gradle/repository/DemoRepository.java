package com.example.demo_gradle.repository;

import com.example.demo_gradle.dto.DemoDTO;
import com.example.demo_gradle.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity,Long> {

    @Modifying
    @Transactional
    @Query("update DemoEntity a set a.name=:name,a.age=:age,a.gender=:gender where a.id=:id")
    int updateById(int id, String name, int age, String gender);

    @Query("select a.name from DemoEntity a")
    List<String> getAll();
}
