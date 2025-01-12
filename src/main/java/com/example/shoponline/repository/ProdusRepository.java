package com.example.shoponline.repository;

import com.example.shoponline.entities.Produs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdusRepository extends JpaRepository<Produs, Long> {

}