package com.example.shoponline.repository;

import com.example.shoponline.entities.CosCumparaturi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CosCumparaturiRepository extends JpaRepository<CosCumparaturi, Long> {
    Optional<CosCumparaturi> findByUtilizatorId(Long utilizatorId);
}