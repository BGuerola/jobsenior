package com.bkjobsenior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Postulacion;
import com.bkjobsenior.service.PostulacionService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/postulaciones")
public class PostulacionController {

    @Autowired
    private PostulacionService postulacionService;
    
    @PostMapping
    public ResponseEntity<Postulacion> crearPostulacion(@RequestBody Postulacion postulacion) {
        Postulacion nuevaPostulacion = postulacionService.crearPostulacion(postulacion);
        return ResponseEntity.ok(nuevaPostulacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postulacion> obtenerPostulacion(@PathVariable Long id) {
        return postulacionService.obtenerPostulacion(id)
                .map(postulacion -> ResponseEntity.ok(postulacion))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/{idoferta}/{idcandidato}")
    public Postulacion obtenerPostulacion(
    		@PathVariable  Integer idoferta,
    		@PathVariable  Integer idcandidato
    ) {
        return postulacionService.obtenerPostulacion(idoferta, idcandidato);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Postulacion> actualizarPostulacion(@PathVariable Long id, @RequestBody Postulacion postulacion) {
        Postulacion postulacionExistente = postulacionService.obtenerPostulacion(id)
                .orElse(null);
        
        if (postulacionExistente == null) {
            return ResponseEntity.notFound().build();
        }

        postulacionExistente.setEstado(postulacion.getEstado());

        Postulacion postulacionActualizada = postulacionService.crearPostulacion(postulacionExistente);

        return ResponseEntity.ok(postulacionActualizada);
    }
}