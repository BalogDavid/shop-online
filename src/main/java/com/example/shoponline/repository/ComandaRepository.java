package com.example.shoponline.repository;

import com.example.shoponline.entities.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    List<Comanda> findByUtilizatorId(Long utilizatorId);
}