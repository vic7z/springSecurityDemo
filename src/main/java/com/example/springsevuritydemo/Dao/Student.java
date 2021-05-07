package com.example.springsevuritydemo.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Students")
public class Student {
    @Id
    private String id;
    private String name;


    public Student(String name) {
        this.name=name;
    }
}
