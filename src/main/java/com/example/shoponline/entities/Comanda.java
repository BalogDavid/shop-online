package com.example.shoponline.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilizator_id", nullable = false)
    private Utilizator utilizator;

    private LocalDate dataComanda;

    @OneToMany(mappedBy = "comanda", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetaliiComanda> detaliiComenzi;

    // Getters, Setters, Constructor
    public Comanda() {}

    public Comanda(Utilizator utilizator, LocalDate dataComanda) {
        this.utilizator = utilizator;
        this.dataComanda = dataComanda;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Utilizator getUtilizator() { return utilizator; }
    public void setUtilizator(Utilizator utilizator) { this.utilizator = utilizator; }

    public LocalDate getDataComanda() { return dataComanda; }
    public void setDataComanda(LocalDate dataComanda) { this.dataComanda = dataComanda; }

    public List<DetaliiComanda> getDetaliiComenzi() { return detaliiComenzi; }
    public void setDetaliiComenzi(List<DetaliiComanda> detaliiComenzi) { this.detaliiComenzi = detaliiComenzi; }
}
