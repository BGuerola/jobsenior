package com.bkjobsenior.service;

import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Empresa;
import com.bkjobsenior.model.Oferta;
import com.bkjobsenior.model.Profesion;
import com.bkjobsenior.model.Provincia;
import com.bkjobsenior.repositori.EmpresaRepo;
import com.bkjobsenior.repositori.OfertaRepo;
import com.bkjobsenior.repositori.ProfesionRepo;
import com.bkjobsenior.repositori.ProvinciaRepo;
import java.util.List;
import java.util.Optional;

@Service
public class OfertaService{

	
    private final OfertaRepo ofertaRepository; 
    private final ProfesionRepo profesionRepository;
    private final ProvinciaRepo provinciaRepository;
    private final EmpresaRepo empresaRepository;
    
    public OfertaService(OfertaRepo ofertaRepository, ProfesionRepo profesionRepository, ProvinciaRepo provinciaRepository,
    		EmpresaRepo empresaRepository) {
        this.ofertaRepository = ofertaRepository;
        this.profesionRepository = profesionRepository;
        this.provinciaRepository = provinciaRepository;
        this.empresaRepository = empresaRepository;
    }
    
    public List<Oferta> listarTodas() {
        return ofertaRepository.findAll();
    }

    public Optional<Oferta> buscarPorId(Integer id) {
        return ofertaRepository.findById(id);
    }
     
    public Oferta guardar(Oferta oferta) {
        Profesion profesionExistente = profesionRepository.findById(oferta.getProfesion().getIdprofesion())
            .orElseThrow(() -> new RuntimeException("Profesion no encontrada"));

        Provincia provinciaExistente = provinciaRepository.findById(oferta.getProvincia().getIdprovincia())
            .orElseThrow(() -> new RuntimeException("Provincia no encontrada"));
        
        Empresa empresaExistente = empresaRepository.findById(oferta.getEmpresa().getIdempresa())
        	    .orElseThrow(() -> new RuntimeException("Empresa no encontrada"));

        oferta.setProfesion(profesionExistente);
        oferta.setProvincia(provinciaExistente);
        oferta.setEmpresa(empresaExistente);

        return ofertaRepository.save(oferta);
    }
    
    public void eliminarPorId(Integer id) {
        ofertaRepository.deleteById(id);
    }
    
    public List<Oferta> getOfertasPorCandidato(Integer idcandidato) {
        return ofertaRepository.findOfertasPorIdCandidato(idcandidato);
    }
    
    public List<Oferta> getOfertasPorEmpresa(Integer idempresa) {
        return ofertaRepository.findByEmpresa_Idempresa(idempresa);
    }  
}