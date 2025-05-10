package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Profesion;

@Repository
public interface ProfesionRepo extends JpaRepository<Profesion, Integer> {
    Profesion findByNombreprofesion(String nombreprofesion);
}
