package com.example.springsevuritydemo.Repository;

import com.example.springsevuritydemo.Dao.Marks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepo extends MongoRepository<Marks,String> {
}
