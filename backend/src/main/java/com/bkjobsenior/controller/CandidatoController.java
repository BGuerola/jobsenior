package com.bkjobsenior.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Candidato;
import com.bkjobsenior.service.CandidatoService;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }
       
    @GetMapping
    public List<Candidato> listarTodos() {
        return candidatoService.listarTodos();
    }

    @GetMapping("/oferta/{id}")
    public List<Candidato>buscarPorIdoferta(@PathVariable Integer id){
    	return candidatoService.getCandidatoPorOfertas(id);
    }

    @GetMapping("/{id}")
    public Optional<Candidato> buscarPorId(@PathVariable Integer id) {
        return candidatoService.buscarPorId(id);
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> comprobarExistenciaCandidatoPorId(@PathVariable Integer id) {
        boolean existe = candidatoService.comprobarExistenciaPorId(id);
        return ResponseEntity.ok(existe);
    }
    
    @PostMapping
    public Candidato guardar(@RequestBody Candidato candidato) {
        return candidatoService.guardar(candidato);
    }
    
    @PostMapping("/crear/{idcandidato}")
    public ResponseEntity<Candidato> crearCandidato(@PathVariable Integer idcandidato) {
    	System.out.println("he entrado en el método crearcandidato");
        Candidato candidato = new Candidato();
        candidato.setIdcandidato(idcandidato);
        candidato.setNombre("");
        candidato.setCorreo("");
        candidato.setUrl("");
        candidato.setDescripcion("");

        Candidato nuevoCandidato = candidatoService.guardar(candidato);
        return ResponseEntity.ok(nuevoCandidato);
    }
        
    @PutMapping("/{id}")
    public Candidato actualizar(@PathVariable Integer id, @RequestBody Candidato candidato) {
        return candidatoService.actualizar(id, candidato);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        candidatoService.eliminarPorId(id);
    }
}