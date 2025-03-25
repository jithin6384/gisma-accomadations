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
    @JoinColumn(name = "seller_id", nullable = false)
    private User seller;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VerificationStatus status = VerificationStatus.PENDING;

    public VerificationRequest() {
    }

    public VerificationRequest( Accommodation accommodation, User seller, VerificationStatus status) {
        this.accommodation = accommodation;
        this.seller = seller;
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
        return seller;
    }

    public void setAdmin(User seller) {
        this.seller = seller;
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
                ", admin=" + seller +
                ", status=" + status +
                '}';
    }
}
