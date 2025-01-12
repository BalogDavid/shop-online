package com.example.shoponline.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String nume;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @OneToMany(mappedBy = "utilizator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CosCumparaturi> cosCumparaturiList; // Changed to a collection for one-to-many relationship

    // Default Constructor
    public Utilizator() {}

    // Constructor with parameters
    public Utilizator(String nume, String email, String password) {
        this.nume = nume;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CosCumparaturi> getCosCumparaturiList() {
        return cosCumparaturiList;
    }

    public void setCosCumparaturiList(List<CosCumparaturi> cosCumparaturiList) {
        this.cosCumparaturiList = cosCumparaturiList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilizator that = (Utilizator) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Utilizator{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}