package com.example.shoponline.repository;

import com.example.shoponline.entities.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilizatorRepository extends JpaRepository<Utilizator, Long> {
    boolean existsByEmail(String email); // Custom query to check duplicate emails
    Optional<Utilizator> findByEmail(String email); // Return Optional to avoid null-pointer issues
}