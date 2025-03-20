package com.example.gisma_accomadation_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "accommodation_visits")
public class VisitorTracking {
    @Id
    private String id;  // MongoDB's unique identifier
    private int accommodationId;  // Links to MySQL accommodation
    private int visitorCount;
    private LocalDateTime lastVisited;

    public VisitorTracking() {
    }

    public VisitorTracking( int accommodationId) {
        this.accommodationId = accommodationId;
        this.visitorCount = 1;
        this.lastVisited = LocalDateTime.now();

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

    public int getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(int visitorCount) {
        this.visitorCount = visitorCount;
    }

    public LocalDateTime getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(LocalDateTime lastVisited) {
        this.lastVisited = lastVisited;
    }

    @Override
    public String toString() {
        return "VisitorTracking{" +
                "id='" + id + '\'' +
                ", accommodationId=" + accommodationId +
                ", visitorCount=" + visitorCount +
                ", lastVisited=" + lastVisited +
                '}';
    }


}
