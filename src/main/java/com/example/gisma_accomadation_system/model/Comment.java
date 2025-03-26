package com.example.gisma_accomadation_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "accommodation_comments")
public class Comment {

    @Id
    private String id;
    private int accommodationId;
    private int userId;
    private String commentText;

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public double getReview() {
        return review;
    }

    public void setReview(double review) {
        this.review = review;
    }

    private double review;
    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment( int accommodationId, int userId, String commentText, double review) {
        this.accommodationId = accommodationId;
        this.userId = userId;
        this.commentText = commentText;
        this.timestamp = LocalDateTime.now();
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId) {
        this.accommodationId = accommodationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", accommodationId=" + accommodationId +
                ", userId=" + userId +
                ", comment='" + commentText + '\'' +
                ", reviews =" +  review +
                ", timestamp=" + timestamp +
                '}';
    }
}
