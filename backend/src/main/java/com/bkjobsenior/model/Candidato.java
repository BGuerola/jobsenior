package com.bkjobsenior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "candidato")
public class Candidato {

    public Candidato() {
	}
    
	public Candidato(Integer idcandidato, String nombre, String correo, String url, String descripcion,
			Inscrito inscrito) {
		this.idcandidato = idcandidato;
		this.nombre = nombre;
		this.correo = correo;
		this.url = url;
		this.descripcion = descripcion;
		this.inscrito = inscrito;
	}

	@Id
    @Column(name = "id_candidato")
    private Integer idcandidato;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo", unique = true)
    private String correo;

    @Column(name = "url")
    private String url;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "id_candidato", referencedColumnName = "idInscrito", insertable = false, updatable = false)
    private Inscrito inscrito;

	public Integer getIdcandidato() {
		return idcandidato;
	}

	public void setIdcandidato(Integer idcandidato) {
		this.idcandidato = idcandidato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}
}
