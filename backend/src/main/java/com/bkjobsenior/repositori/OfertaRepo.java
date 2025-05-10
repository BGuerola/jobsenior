package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Oferta;
import com.bkjobsenior.model.Profesion;
import com.bkjobsenior.model.Provincia;

import java.util.List;

@Repository
public interface OfertaRepo extends JpaRepository<Oferta, Integer> {
    List<Oferta> findByEmpresa_Idempresa(Integer idempresa);
    List<Oferta> findByProfesion(Profesion profesion);
    List<Oferta> findByProvincia(Provincia provincia);
    
   
@Query("SELECT o FROM Oferta o WHERE o.idoferta IN (SELECT p.idoferta FROM Postulacion p WHERE p.idcandidato = :idcandidato)")
    List<Oferta> findOfertasPorIdCandidato(@Param("idcandidato") Integer idcandidato);
}