package com.gevernova.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Greeting {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    // Default constructor (required by JPA)
    public Greeting() {}

    // Constructor with message
    public Greeting(String message){
        this.message = message;
    }
    // Constructor with id and message (optional, useful for updates)
    public Greeting(Long id, String message) {
        this.id = id;
        this.message = message;
    }
    // Getter and Setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}