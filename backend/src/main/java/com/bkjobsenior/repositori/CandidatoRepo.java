package com.bkjobsenior.repositori;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Candidato;

@Repository
public interface CandidatoRepo extends JpaRepository<Candidato, Integer> {
    
    Candidato findByCorreo(String correo);

    @Query("SELECT o FROM Candidato o WHERE o.idcandidato IN (SELECT p.idcandidato FROM Postulacion p WHERE p.idoferta = :idoferta)")
    List<Candidato> findByIdoferta(@Param("idoferta") Integer idoferta);
}