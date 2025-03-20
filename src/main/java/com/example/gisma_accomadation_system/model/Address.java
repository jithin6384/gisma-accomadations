package com.example.gisma_accomadation_system.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {
    @Id
    private String id;
    private int accommodationId;  // Foreign key to SQL accommodation
    private String street;
    private String city;
    private String postalCode;
    private String zone;
    private String country;

    public Address() {
    }

    public Address( int accommodationId, String street, String city, String postalCode, String zone, String country) {
        this.accommodationId = accommodationId;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.zone = zone;
        this.country = country;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id='" + id + '\'' +
                ", accommodationId=" + accommodationId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", zone='" + zone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
