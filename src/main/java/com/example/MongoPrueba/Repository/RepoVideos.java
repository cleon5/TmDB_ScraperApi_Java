package com.example.MongoPrueba.Repository;

import com.example.MongoPrueba.Entity.Videos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoVideos extends MongoRepository<Videos, String> {
}
