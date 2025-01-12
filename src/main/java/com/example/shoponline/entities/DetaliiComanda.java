package com.example.shoponline.entities;

import jakarta.persistence.*;

@Entity
public class DetaliiComanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "comanda_id", nullable = false)
    private Comanda comanda;

    @ManyToOne
    @JoinColumn(name = "produs_id", nullable = false)
    private Produs produs;

    private Integer cantitate;
    private Double pret;

    // Getters, Setters, Constructor
    public DetaliiComanda() {}

    public DetaliiComanda(Comanda comanda, Produs produs, Integer cantitate, Double pret) {
        this.comanda = comanda;
        this.produs = produs;
        this.cantitate = cantitate;
        this.pret = pret;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Comanda getComanda() { return comanda; }
    public void setComanda(Comanda comanda) { this.comanda = comanda; }

    public Produs getProdus() { return produs; }
    public void setProdus(Produs produs) { this.produs = produs; }

    public Integer getCantitate() { return cantitate; }
    public void setCantitate(Integer cantitate) { this.cantitate = cantitate; }

    public Double getPret() { return pret; }
    public void setPret(Double pret) { this.pret = pret; }
}
