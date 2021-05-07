package com.example.springsevuritydemo.Repository;

import com.example.springsevuritydemo.Dao.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {
    @Query("{ 'name' : ?0 }")
    List<Student> findStudentByName(String name);
}
