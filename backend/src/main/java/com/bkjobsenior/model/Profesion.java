package com.bkjobsenior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "profesiones")
public class Profesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesion")
    private Integer idprofesion;

    @Column(name = "nombre_profesion", nullable = false, unique = true)
    private String nombreprofesion;
  
    public Profesion() {
	}

	public Profesion(Integer idprofesion, String nombreprofesion) {
		this.idprofesion = idprofesion;
		this.nombreprofesion = nombreprofesion;
	}

	public Integer getIdprofesion() {
		return idprofesion;
	}

	public void setIdprofesion(Integer idprofesion) {
		this.idprofesion = idprofesion;
	}

	public String getNombreprofesion() {
		return nombreprofesion;
	}

	public void setNombreprofesion(String nombreprofesion) {
		this.nombreprofesion = nombreprofesion;
	}    
}
