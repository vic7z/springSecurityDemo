package com.example.springsevuritydemo.Controller;

import com.example.springsevuritydemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class adminControllere {
    private final AdminService adminService;

    @Autowired
    public adminControllere(AdminService adminService) {
        this.adminService = adminService;
    }

}
