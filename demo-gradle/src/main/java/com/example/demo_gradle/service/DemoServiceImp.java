package com.example.demo_gradle.service;

import com.example.demo_gradle.dto.DemoDTO;
import com.example.demo_gradle.entity.DemoEntity;
import com.example.demo_gradle.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemoServiceImp implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public DemoEntity save(DemoDTO demoDTO) {

        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(demoDTO.getName());
        demoEntity.setAge(demoDTO.getAge());
        demoEntity.setGender(demoDTO.getGender());
        return demoRepository.save(demoEntity);

    }

    @Override
    public Optional<DemoEntity> getAllById(int id) {
        return demoRepository.findById(Long.valueOf(id));
    }



    @Override
    public void updateById(int id, String name, int age, String gender) {

        demoRepository.updateById(id,name,age,gender);
    }

    @Override
    public void deleteById(int id) {
        demoRepository.deleteById(Long.valueOf(id));
    }

}
