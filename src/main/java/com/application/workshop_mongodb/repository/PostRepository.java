package com.application.workshop_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.application.workshop_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
