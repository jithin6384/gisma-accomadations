package com.example.gisma_accomadation_system.repo;


import com.example.gisma_accomadation_system.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends MongoRepository<Comment, String> {
    List<Comment> findCommentsByAccommodationId(int accommodationId);
}
