package com.example.springsevuritydemo;

import com.example.springsevuritydemo.Repository.MarksRepo;
import com.example.springsevuritydemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication implements CommandLineRunner {
    public final StudentRepo studentRepo;
    @Autowired
    public MarksRepo marksRepo;

    public SpringSecurityDemoApplication(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepo.deleteAll();
//        studentRepo.save(new Student("vic"));
//        studentRepo.saveAll(Arrays.asList(
//                new Student("pooja"),
//                new Student("anu"),
//                new Student("asvin")
//        ));

     marksRepo.deleteAll();
    }
}
