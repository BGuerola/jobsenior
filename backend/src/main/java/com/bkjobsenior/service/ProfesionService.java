package com.bkjobsenior.service;

import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Profesion;
import com.bkjobsenior.repositori.ProfesionRepo;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesionService {

    private final ProfesionRepo profesionRepository;

    public ProfesionService(ProfesionRepo profesionRepository) {
        this.profesionRepository = profesionRepository;
    }

    public List<Profesion> listarTodas() {
        return profesionRepository.findAll();
    }

    public Optional<Profesion> buscarPorId(Integer id) {
        return profesionRepository.findById(id);
    }

    public Profesion guardar(Profesion profesion) {
        return profesionRepository.save(profesion);
    }

    public void eliminarPorId(Integer id) {
        profesionRepository.deleteById(id);
    }
}