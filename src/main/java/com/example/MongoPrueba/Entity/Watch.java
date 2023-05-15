package com.example.MongoPrueba.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "watchSeries")
@AllArgsConstructor
@NoArgsConstructor
public class Watch {
    @Id
    private String _id;
    private int id;
    private Object results;
}
