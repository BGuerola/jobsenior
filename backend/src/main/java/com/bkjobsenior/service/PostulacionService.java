package com.bkjobsenior.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Postulacion;
import com.bkjobsenior.repositori.PostulacionRepo;
import java.util.Optional;

@Service
public class PostulacionService {

    @Autowired
    private PostulacionRepo postulacionRepo;

    public Postulacion crearPostulacion(Postulacion postulacion) {
        return postulacionRepo.save(postulacion);
    }

    public Optional<Postulacion> obtenerPostulacion(Long id) {
        return postulacionRepo.findById(id);
    }
    
    public Postulacion obtenerPostulacion(Integer idoferta, Integer idcandidato) {
        return postulacionRepo.findByIdofertaAndIdcandidato(idoferta, idcandidato);
    }
}