package com.example.MongoPrueba.Repository;

import com.example.MongoPrueba.Entity.Credits;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface RepoLista extends MongoRepository<Map, String> {
}
