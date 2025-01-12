package com.example.shoponline.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class CosCumparaturi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilizator_id", nullable = false)
    private Utilizator utilizator; // Many carts belong to one user

    @ManyToMany
    @JoinTable(
            name = "cos_cumparaturi_produse",
            joinColumns = @JoinColumn(name = "cos_id"),
            inverseJoinColumns = @JoinColumn(name = "produs_id")
    )
    private List<Produs> produse; // Many-to-many relationship with products

    // Default Constructor
    public CosCumparaturi() {}

    // Constructor with parameters
    public CosCumparaturi(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilizator getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    @Override
    public String toString() {
        return "CosCumparaturi{" +
                "id=" + id +
                ", utilizatorId=" + (utilizator != null ? utilizator.getId() : null) +
                '}';
    }
}