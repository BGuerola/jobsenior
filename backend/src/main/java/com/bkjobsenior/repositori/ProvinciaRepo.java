package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Provincia;

@Repository
public interface ProvinciaRepo extends JpaRepository<Provincia, Integer> {
    Provincia findByNombreprovincia(String nombreprovincia);
}
