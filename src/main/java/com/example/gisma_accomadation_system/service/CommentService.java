package com.example.gisma_accomadation_system.service;

import com.example.gisma_accomadation_system.model.Comment;
import com.example.gisma_accomadation_system.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;


    public List<Comment> getCommentsByAccommodation(int accommodationId) {
        return commentRepo.findCommentsByAccommodationId(accommodationId);
    }

    public Comment addComment(Comment comment, int accommodationId) {
        comment.setAccommodationId(accommodationId);
        return commentRepo.save(comment);

    }
}
