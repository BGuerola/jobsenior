package com.bkjobsenior.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bkjobsenior.model.Postulacion;

@Repository
public interface PostulacionRepo extends JpaRepository<Postulacion, Long> {

@Query("SELECT o FROM Postulacion o WHERE o.idoferta = :idoferta and o.idcandidato = :idCandidato")
Postulacion findByIdofertaAndIdcandidato(@Param("idoferta") Integer idoferta, @Param("idCandidato") Integer idCandidato);
}