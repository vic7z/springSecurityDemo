package com.example.springsevuritydemo.Controller;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class adminControllere {
    private final AdminService adminService;

    @Autowired
    public adminControllere(AdminService adminService) {
        this.adminService = adminService;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteStudents(@PathVariable String id){
        return this.adminService.deleteStudent(id);
    }
    @DeleteMapping(path = "/name/{name}")
    public ResponseEntity<Void> deleteStudentsByName(@PathVariable String id){
        return this.adminService.deleteStudentByName(id);
    }
    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody Student student){
        return this.adminService.addStudent(student);
    }





}
