package com.example.MongoPrueba.Repository;
import com.example.MongoPrueba.Entity.Tv;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoTv extends MongoRepository<Tv, String>{
}
