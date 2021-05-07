package com.example.springsevuritydemo.Dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "marks")
public class Marks {

    @Id
    String id;
    int marks;

    public Marks(int i) {
        this.marks=i;
    }
}
