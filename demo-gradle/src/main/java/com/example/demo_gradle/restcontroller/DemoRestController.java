package com.example.demo_gradle.restcontroller;

import com.example.demo_gradle.dto.DemoDTO;
import com.example.demo_gradle.entity.DemoEntity;
import com.example.demo_gradle.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//  RestController - Controller + Response body
@RestController
@RequestMapping("/customer")
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


    @PostMapping()

    public void save(@RequestBody DemoDTO demoDTO){
         demoService.save(demoDTO);
    }

    @GetMapping("/{id}")
    public void getAllById(@PathVariable int id){
        Optional<DemoEntity> list= demoService.getAllById(id);
        System.out.println(list);
    }

    @PutMapping("/{id}")
    public void onUpdate(@PathVariable int id,@RequestBody DemoDTO demoDTO){
        demoService.updateById(id,demoDTO.getName(),demoDTO.getAge(),demoDTO.getGender());
    }

    @DeleteMapping("/delete/{id}")
    public void onDelete(@PathVariable int id){
        demoService.deleteById(id);
    }

    @GetMapping
    public Page<DemoEntity> getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "true") boolean ascending
    ) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return demoService.findAll(pageable);
    }
}
