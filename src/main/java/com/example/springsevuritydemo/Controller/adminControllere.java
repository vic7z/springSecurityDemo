package com.example.springsevuritydemo.Controller;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteStudents(@PathVariable String id){
        return this.adminService.deleteStudent(id);
    }
    @DeleteMapping(path = "/name/{name}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteStudentsByName(@PathVariable String name){
        System.out.println("delete");
        return this.adminService.deleteStudentByName(name);
    }
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> add(@RequestBody Student student){
        return this.adminService.addStudent(student);
    }





}
