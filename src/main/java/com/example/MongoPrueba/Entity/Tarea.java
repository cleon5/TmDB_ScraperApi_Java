package com.example.MongoPrueba.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "tareas")
public class Tarea {
    @Id
    private String _id;
    private String titulo;
    private String descripcion;
    private String tipo;
}
