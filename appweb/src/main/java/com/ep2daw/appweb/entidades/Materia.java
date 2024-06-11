/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author josue
 */

@Entity
@Table(name="materia")
public class Materia implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_id_seq")
    @SequenceGenerator(name="materia_id_seq", sequenceName="materia_id_seq", allocationSize=1)
    @Column(name="id")
    private Integer id;
    
    @Column(name="nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL)
    private List<Inscripcion> inscripciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Materia{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public Materia(Integer id) {
        this.id = id;
    }

    public Materia(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Materia() {
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
}
