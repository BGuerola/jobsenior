package com.bkjobsenior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Column(name = "id_empresa")
    private Integer idempresa;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "url", unique = true)
    private String url;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "id_empresa", referencedColumnName = "idInscrito", insertable = false, updatable = false)
    private Inscrito inscrito;
    
	public Empresa() {
	}
	
	public Empresa(Integer idempresa, String nombre, String url, String direccion, String descripcion,
			Inscrito inscrito) {
		this.idempresa = idempresa;
		this.nombre = nombre;
		this.url = url;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.inscrito = inscrito;
	}

	public Integer getIdempresa() {
		return idempresa;
	}

	public void setIdEmpresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
