package com.bkjobsenior.service;

import org.springframework.stereotype.Service;
import com.bkjobsenior.model.Empresa;
import com.bkjobsenior.repositori.EmpresaRepo;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    private final EmpresaRepo empresaRepository;

    public EmpresaService(EmpresaRepo empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> listarTodas() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> buscarPorId(Integer id) {
        return empresaRepository.findById(id);
    }
    
    public boolean comprobarExistenciaPorId(Integer id) {
        return empresaRepository.existsById(id);
    }

    public Empresa guardar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void eliminarPorId(Integer id) {
        empresaRepository.deleteById(id);
    }

	public Empresa actualizar(Integer id, Empresa empresa) {
		return empresaRepository.save(empresa); 
	}    
}
