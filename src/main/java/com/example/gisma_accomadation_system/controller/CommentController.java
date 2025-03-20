package com.example.gisma_accomadation_system.controller;

import com.example.gisma_accomadation_system.model.Comment;
import com.example.gisma_accomadation_system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comments/{accommodationId}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable int accommodationId) {

        return new  ResponseEntity<>(commentService.getCommentsByAccommodation(accommodationId), HttpStatus.OK);
    }

    @PostMapping("/comment/{accommodationId}")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment, @PathVariable int accommodationId ){
        return new ResponseEntity<>(commentService.addComment(comment, accommodationId), HttpStatus.OK);
    }


}
