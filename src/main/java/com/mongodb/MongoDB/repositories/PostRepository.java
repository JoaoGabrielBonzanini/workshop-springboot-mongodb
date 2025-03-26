package com.mongodb.MongoDB.repositories;

import com.mongodb.MongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
