package com.example.MongoPrueba.Repository;

import com.example.MongoPrueba.Entity.Credits;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoCreditos extends MongoRepository<Credits, String> {
}
