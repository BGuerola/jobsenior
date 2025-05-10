package com.bkjobsenior.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Inscrito;
import com.bkjobsenior.repositori.InscritoRepo;

@Service
public class InscritoService {

    @Autowired
    private InscritoRepo inscritoRepo;

    public boolean registrar(Inscrito inscrito) {
        Inscrito existente = inscritoRepo.findByNombre(inscrito.getNombre());
        if (existente != null) {
            return false;
        }

        inscritoRepo.save(inscrito);
        return true;
    }

    public Inscrito login(String username, String password) {
        return inscritoRepo.findByNombreAndContrasena(username, password);
    }
}