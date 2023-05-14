package com.example.MongoPrueba.Repository;

import com.example.MongoPrueba.Entity.Watch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface RepoWatch extends MongoRepository<Watch, String> {
}
