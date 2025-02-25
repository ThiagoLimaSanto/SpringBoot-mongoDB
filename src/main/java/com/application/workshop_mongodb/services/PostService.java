package com.application.workshop_mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.workshop_mongodb.domain.Post;
import com.application.workshop_mongodb.repository.PostRepository;
import com.application.workshop_mongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User not found!"));
        if (post == null) {
            throw new ObjectNotFoundException("User not found!");
        }
        return post;
    }

    public List<Post> findByTitle(String text){
        return repository.searchTitle(text);
    }
}
