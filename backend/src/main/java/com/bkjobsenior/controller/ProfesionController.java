package com.bkjobsenior.controller;

import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Profesion;
import com.bkjobsenior.service.ProfesionService;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/profesiones")
public class ProfesionController {

    private final ProfesionService profesionService;

    public ProfesionController(ProfesionService profesionService) {
        this.profesionService = profesionService;
    }

    @GetMapping
    public List<Profesion> listarTodas() {
        return profesionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Profesion> buscarPorId(@PathVariable Integer id) {
        return profesionService.buscarPorId(id);
    }

    @PostMapping
    public Profesion guardar(@RequestBody Profesion profesion) {
        return profesionService.guardar(profesion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        profesionService.eliminarPorId(id);
    }
}