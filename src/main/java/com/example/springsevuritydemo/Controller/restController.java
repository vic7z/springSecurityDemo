package com.example.springsevuritydemo.Controller;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/students")
public class restController{
    public final Studentservice studentservice;
    @Autowired
    public restController(Studentservice studentservice) {
        this.studentservice = studentservice;
    }

//    @GetMapping(path = "/students")
//    public List<Student> getAll(){
//        return studentservice.getAllStudent();
//    }
    @GetMapping(path = "/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        return studentservice.getAllStudents();
    }

    @GetMapping(path = "/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        return studentservice.getstudentById(id);
    }
    @GetMapping(path = "/students/name/{name}")
    public List<Student> getstudent(@PathVariable String name){
        return this.studentservice.getStudent(name);
    }


}
