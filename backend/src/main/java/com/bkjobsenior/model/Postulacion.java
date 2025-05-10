package com.bkjobsenior.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "postulaciones")
public class Postulacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postulacion")
    private Long idpostulacion;

    @Column(name = "id_candidato", nullable = false)
    private Integer idcandidato;

    @Column(name = "id_oferta", nullable = false)
    private Integer idoferta;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "fecha")
    private LocalDate fecha;
    
    @Column(name = "motivacion")
    private String motivacion;

    public Postulacion() {}

    public Postulacion(Long idpostulacion, Integer idcandidato, Integer idoferta, String estado, LocalDate fecha,
			String motivacion) {
		this.idpostulacion = idpostulacion;
		this.idcandidato = idcandidato;
		this.idoferta = idoferta;
		this.estado = estado;
		this.fecha = fecha;
		this.motivacion = motivacion;
	}

	public Long getId() {
		return idpostulacion;
	}

	public Integer getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(Integer idcandidato) {
		this.idcandidato = idcandidato;
	}

	public Integer getIdoferta() {
		return idoferta;
	}

	public void setIdoferta(Integer idoferta) {
		this.idoferta = idoferta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMotivacion() {
		return motivacion;
	}

	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}
}