package com.example.MongoPrueba.Repository;

import com.example.MongoPrueba.Entity.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPeliculas extends MongoRepository<Pelicula, String> {
}
