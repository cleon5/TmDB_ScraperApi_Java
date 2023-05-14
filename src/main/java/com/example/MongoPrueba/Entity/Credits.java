package com.example.MongoPrueba.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "creditos")
public class Credits {
    @Id
    private String _id;
    private int id;
    private Object cast;
    private Object crew;
}
