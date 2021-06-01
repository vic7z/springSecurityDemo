package com.example.springsevuritydemo.Controller;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/students")
public class StudentController {
    public final Studentservice studentservice;
    @Autowired
    public StudentController(Studentservice studentservice) {
        this.studentservice = studentservice;
    }

//    @GetMapping(path = "/students")
//    public List<Student> getAll(){
//        return studentservice.getAllStudent();
//    }
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<Student>> getAllStudent(){
        return studentservice.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAnyRole('ROLE_STUDENT','ROLE_ADMIN')")
    public ResponseEntity<Student> getStudentById(@PathVariable String id){
        return studentservice.getstudentById(id);
    }
    @GetMapping(path = "/name/{name}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Student> getStudent(@PathVariable String name){
        return this.studentservice.getStudent(name);
    }


}
