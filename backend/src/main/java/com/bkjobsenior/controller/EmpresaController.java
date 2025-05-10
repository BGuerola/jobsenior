package com.bkjobsenior.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bkjobsenior.model.Empresa;
import com.bkjobsenior.service.EmpresaService;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public List<Empresa> listarTodas() {
        return empresaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Empresa> buscarPorId(@PathVariable Integer id) {
        return empresaService.buscarPorId(id);
    }
    
    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> comprobarExistenciaEmpresaPorId(@PathVariable Integer id) {
        boolean existe = empresaService.comprobarExistenciaPorId(id);
        return ResponseEntity.ok(existe);
    }

    @PostMapping
    public Empresa guardar(@RequestBody Empresa empresa) {
        return empresaService.guardar(empresa);
    }
    
    @PostMapping("/crear/{idempresa}")
    public ResponseEntity<Empresa> crearEmpresa(@PathVariable Integer idempresa) {
    	Empresa empresa = new Empresa();
    	empresa.setIdEmpresa(idempresa);
    	empresa.setNombre("");
    	empresa.setUrl("");
    	empresa.setDireccion("");
    	empresa.setDescripcion("");

    	Empresa nuevaEmpresa = empresaService.guardar(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }
    
    @PutMapping("/{id}")
    public Empresa actualizar(@PathVariable Integer id, @RequestBody Empresa empresa) {
    	System.out.println("entra en el método put del controlador");
        return empresaService.actualizar(id, empresa);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        empresaService.eliminarPorId(id);
    }
}