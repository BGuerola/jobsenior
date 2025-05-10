package com.bkjobsenior.controller;

import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Provincia;
import com.bkjobsenior.service.ProvinciaService;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    private final ProvinciaService provinciaService;

    public ProvinciaController(ProvinciaService provinciaService) {
        this.provinciaService = provinciaService;
    }

    @GetMapping
    public List<Provincia> listarTodas() {
        return provinciaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Provincia> buscarPorId(@PathVariable Integer id) {
        return provinciaService.buscarPorId(id);
    }

    @PostMapping
    public Provincia guardar(@RequestBody Provincia provincia) {
        return provinciaService.guardar(provincia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        provinciaService.eliminarPorId(id);
    }
}