package com.devkng.crudapi.controller;

import com.devkng.crudapi.entity.Student;
import com.devkng.crudapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    @Autowired
    StudentRepository repo ;

    // Get All Data -> Students
    @GetMapping("/students")
    public List<Student> getAllStudents(){

        List<Student> students = repo.findAll();

        return students ;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = repo.findById(id).get();
        return student ;
    }


    // Create
    @PostMapping("/student/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createStudent(@RequestBody Student student) {
        repo.save(student);
    }

    @PostMapping("/student/update/{id}")
    public Student updateStudent(@PathVariable int id){
        Student s = repo.findById(id).get();
        s.setName("Deafult");
        s.setPercentage(String.valueOf(80));
        s.setBranch("CSE");
        repo.save(s);

        return s ;

    }
    @DeleteMapping("student/delete/{id}")
    public void removveStudent(@PathVariable int id){
        Student s = repo.findById(id).get();
        repo.delete(s);
    }




}
