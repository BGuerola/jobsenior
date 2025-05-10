package com.bkjobsenior.model;

import jakarta.persistence.*;

@Entity
@Table(name = "inscritos")
public class Inscrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscrito")
    private Integer idInscrito;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasena")
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoInscrito tipo;
   
    public Inscrito() {
	}
    
	public Inscrito(Integer idInscrito, String nombre, String contrasena, TipoInscrito tipo) {
		this.idInscrito = idInscrito;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.tipo = tipo;
	}

	public enum TipoInscrito {
        empresa,
        candidato
    }

	public Integer getIdInscrito() {
		return idInscrito;
	}

	public void setIdInscrito(Integer idInscrito) {
		this.idInscrito = idInscrito;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoInscrito getTipo() {
		return tipo;
	}

	public void setTipo(TipoInscrito tipo) {
		this.tipo = tipo;
	}
}