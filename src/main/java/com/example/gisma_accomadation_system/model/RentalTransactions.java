package com.example.gisma_accomadation_system.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Table(name = "rental_transactions")
public class RentalTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "accommodation_id", nullable = false)
    private Accommodation accommodation;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    private Timestamp rentedAt = new Timestamp(System.currentTimeMillis());

    public RentalTransactions() {
    }

    public RentalTransactions(Accommodation accommodation, User student) {

        this.accommodation = accommodation;
        this.student = student;
        this.rentedAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Timestamp getRentedAt() {
        return rentedAt;
    }

    public void setRentedAt(Timestamp rentedAt) {
        this.rentedAt = rentedAt;
    }

    @Override
    public String toString() {
        return "RentalTransactions{" +
                "id=" + id +
                ", accommodation=" + accommodation +
                ", student=" + student +
                ", rentedAt=" + rentedAt +
                '}';
    }
}
