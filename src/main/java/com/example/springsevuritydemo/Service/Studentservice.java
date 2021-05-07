package com.example.springsevuritydemo.Service;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class Studentservice {
    public final StudentRepo studentRepo;

    @Autowired
    public Studentservice(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudent(String name){
        return studentRepo.findStudentByName(name);
    }

//    public Student getStudentById(String id){
//        return studentRepo.findById(id).orElseThrow();
//    }


    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentRepo.findAll();
        if(students.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else {
            return ResponseEntity.ok(students);
        }
    }

    public ResponseEntity<Student> getstudentById(String id){
        Student student=studentRepo.findById(id).orElse(null);
        if(student!=null){
            return ResponseEntity.ok(student);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
