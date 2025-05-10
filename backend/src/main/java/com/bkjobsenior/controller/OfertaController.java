package com.bkjobsenior.controller;

import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Oferta;
import com.bkjobsenior.service.OfertaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ofertas")
public class OfertaController {

    private final OfertaService ofertaService;
    private static final Logger log = LoggerFactory.getLogger(OfertaController.class);

    public OfertaController(OfertaService ofertaService) {
        this.ofertaService = ofertaService;
    }
    
    @GetMapping
    public List<Oferta> listarTodas() {
        return ofertaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Oferta> buscarPorId(@PathVariable Integer id) {
        return ofertaService.buscarPorId(id);
    }

    @GetMapping("/candidato/{idcandidato}")
    public List<Oferta> getOfertasPorCandidato(@PathVariable Integer idcandidato) {
        return ofertaService.getOfertasPorCandidato(idcandidato);
    }
    
    @GetMapping("/empresa/{idempresa}")
    public List<Oferta> getOfertasPorEmpresa(@PathVariable Integer idempresa) {
        return ofertaService.getOfertasPorEmpresa(idempresa);
    }

    @PostMapping
    public Oferta guardar(@RequestBody Oferta oferta) {
        log.info("DTO recibido: {}", oferta);

        if (oferta.getProfesion().getIdprofesion() == null || oferta.getProvincia().getIdprovincia() == null) {
            log.error("IDs nulos recibidos: idprofesion={}, idprovincia={}", 
                oferta.getProfesion().getIdprofesion(), oferta.getProvincia().getIdprovincia());
            throw new IllegalArgumentException("IDs no pueden ser nulos");
        }

        return ofertaService.guardar(oferta);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        ofertaService.eliminarPorId(id);
    }
}