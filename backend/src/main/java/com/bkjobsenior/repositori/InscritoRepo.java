package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Inscrito;

@Repository
public interface InscritoRepo extends JpaRepository<Inscrito, Integer> {
    Inscrito findByNombre(String nombre);
    Inscrito findByNombreAndContrasena(String nombre, String contrasena);
    
}