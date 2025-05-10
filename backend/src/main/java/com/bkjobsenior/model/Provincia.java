package com.bkjobsenior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "provincias")
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provincia")
    private Integer idprovincia;

    @Column(name= "nombre_provincia", nullable = false, unique = true)
    private String nombreprovincia;

    public Provincia() {
	}
    
	public Provincia(Integer idprovincia, String nombreprovincia) {
		this.idprovincia = idprovincia;
		this.nombreprovincia = nombreprovincia;
	}

	public Integer getIdprovincia() {
		return idprovincia;
	}

	public void setIdprovincia(Integer idprovincia) {
		this.idprovincia = idprovincia;
	}

	public String getNombreprovincia() {
		return nombreprovincia;
	}

	public void setNombreprovincia(String nombreprovincia) {
		this.nombreprovincia = nombreprovincia;
	}
   
}
