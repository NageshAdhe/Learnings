package com.igat.SpringSecureEx.controller;

import com.igat.SpringSecureEx.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    private List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Kiran",45),
            new Student(2,"Akshay",50)
    ));
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return  students;
    }
}
