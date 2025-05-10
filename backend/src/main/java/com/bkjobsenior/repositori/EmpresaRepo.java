package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Empresa;

@Repository
public interface EmpresaRepo extends JpaRepository<Empresa, Integer> {
}