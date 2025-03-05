package com.example.demo_gradle.restcontroller;

import com.example.demo_gradle.dto.DemoDTO;
import com.example.demo_gradle.entity.DemoEntity;
import com.example.demo_gradle.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//  RestController - Controller + Response body
@RestController
@RequestMapping("/")
public class DemoRestController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    public String on(){
        return "Hello Good Morning ";
    }
    @GetMapping("/click/{name}")
    @ResponseBody
    public String onclick(@PathVariable String name){
        return "Hello Good Morning "+name;
    }


    @GetMapping("/press")
    public String press(@RequestParam String name){
        return "hello Good Morning "+name;
    }


    @PostMapping("/save")

    public void save(@RequestBody DemoDTO demoDTO){
         demoService.save(demoDTO);
    }

    @GetMapping("/getDetails/{id}")
    public void getAllById(@PathVariable int id){
        Optional<DemoEntity> list= demoService.getAllById(id);
        System.out.println(list);
    }

    @PutMapping("/update/{id}")
    public void onUpdate(@PathVariable int id,@RequestBody DemoDTO demoDTO){
        demoService.updateById(id,demoDTO.getName(),demoDTO.getAge(),demoDTO.getGender());
    }

    @DeleteMapping("/delete/{id}")
    public void onDelete(@PathVariable int id){
        demoService.deleteById(id);
    }
}
