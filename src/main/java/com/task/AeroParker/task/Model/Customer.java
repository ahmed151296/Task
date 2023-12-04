package com.task.AeroParker.task.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime registered;
    @PrePersist
    protected void onCreate() {
        registered = LocalDateTime.now();
    }

    @Column(nullable = false, unique = true, length = 255)
    private String emailAddress;

    @Column(nullable = false, length = 5)
    private String title;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 255)
    private String address_Line_1;

    @Column(length = 255)
    private String address_Line_2;

    @Column(length = 255)
    private String city;

    @Column(nullable = false, length = 10)
    private String postcode;

    @Column(length = 20)
    private String phoneNumber;

    // Default constructor
    public Customer() {
    }

    // Constructor with parameters (excluding id and registered)
    public Customer(String emailAddress, String title, String firstName, String lastName,
                    String address_Line_1, String address_Line_2, String city, String postcode,
                    String phoneNumber) {
        this.emailAddress = emailAddress;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address_Line_1 = address_Line_1;
        this.address_Line_2 = address_Line_2;
        this.city = city;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.registered = LocalDateTime.now(); // Automatically set the registration time
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return address_Line_1;
    }

    public void setAddressLine1(String addressLine1) {
        this.address_Line_1 = addressLine1;
    }

    public String getAddressLine2() {
        return address_Line_2;
    }

    public void setAddressLine2(String addressLine2) {
        this.address_Line_2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

