package com.example.springsevuritydemo.Service;

import com.example.springsevuritydemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final StudentRepo studentRepo;

    @Autowired
    public AdminService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
}
