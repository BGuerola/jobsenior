package com.bkjobsenior.service;

import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Provincia;
import com.bkjobsenior.repositori.ProvinciaRepo;
import java.util.List;
import java.util.Optional;

@Service
public class ProvinciaService {

    private final ProvinciaRepo provinciaRepository;

    public ProvinciaService(ProvinciaRepo provinciaRepository) {
        this.provinciaRepository = provinciaRepository;
    }

    public List<Provincia> listarTodas() {
        return provinciaRepository.findAll();
    }

    public Optional<Provincia> buscarPorId(Integer id) {
        return provinciaRepository.findById(id);
    }

    public Provincia guardar(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    public void eliminarPorId(Integer id) {
        provinciaRepository.deleteById(id);
    }
}