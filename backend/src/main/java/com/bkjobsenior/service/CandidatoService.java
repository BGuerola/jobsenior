package com.bkjobsenior.service;

import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Candidato;
import com.bkjobsenior.repositori.CandidatoRepo;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatoService {

    private final CandidatoRepo candidatoRepository;

    public CandidatoService(CandidatoRepo candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public List<Candidato> getCandidatoPorOfertas(Integer idoferta) {
        return candidatoRepository.findByIdoferta(idoferta);
    }
    
    public List<Candidato> listarTodos() {
        return candidatoRepository.findAll();
    }

    public Optional<Candidato> buscarPorId(Integer id) {
        return candidatoRepository.findById(id);
    }
    
    public boolean comprobarExistenciaPorId(Integer id) {
        return candidatoRepository.existsById(id);
    }

    public Candidato guardar(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    public void eliminarPorId(Integer id) {
        candidatoRepository.deleteById(id);
    }
	
    public Candidato actualizar(Integer id, Candidato candidato) { 
    	return candidatoRepository.save(candidato); 
    }	
}
