package com.example.gisma_accomadation_system.model;
import jakarta.persistence.*;
@Entity
@Table(name="verification_requests")
public class VerificationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "accommodation_id", nullable = false )
    private Accommodation accommodation;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VerificationStatus status = VerificationStatus.PENDING;

    public VerificationRequest() {
    }

    public VerificationRequest( Accommodation accommodation, User admin, VerificationStatus status) {
        this.accommodation = accommodation;
        this.admin = admin;
        this.status = status;
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

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public VerificationStatus getStatus() {
        return status;
    }

    public void setStatus(VerificationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VerificationRequest{" +
                "id=" + id +
                ", accommodation=" + accommodation +
                ", admin=" + admin +
                ", status=" + status +
                '}';
    }
}
