package com.example.MongoPrueba.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "videosSeries")
public class Videos {
    @Id
    private String _id;
    private int id;
    private Object results;
}

