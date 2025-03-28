package com.mongodb.MongoDB.services;

import com.mongodb.MongoDB.domain.Post;
import com.mongodb.MongoDB.repositories.PostRepository;
import com.mongodb.MongoDB.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id){
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }
}
