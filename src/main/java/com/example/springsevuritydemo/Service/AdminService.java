package com.example.springsevuritydemo.Service;

import com.example.springsevuritydemo.Dao.Student;
import com.example.springsevuritydemo.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    private final StudentRepo studentRepo;

    @Autowired
    public AdminService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public ResponseEntity<Void> deleteStudent(String id){
        Student student=studentRepo.findById(id).orElse(null);

        if (student!=null){
            studentRepo.delete(student);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    public ResponseEntity<Void> deleteStudentByName(String name){
        Student student=studentRepo.findStudentByName(name).orElse(null);
        //System.out.println(student.toString());
        if (student!=null){
            studentRepo.delete(student);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

    }

    public ResponseEntity<Void> addStudent(Student student){
        this.studentRepo.save(student);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Student> updateStudent(Student student,String id){
        Student student1=this.studentRepo.findById(id).orElse(null);
        if (student1 !=null){
            this.studentRepo.save(student1);
            return ResponseEntity.ok(student1);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}
