/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author josue
 */

@Entity
@Table(name="inscripcion")
public class Inscripcion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materia")
    private Materia materia;
    
    @Column
    private Integer anio;
    
    @Column 
    private String ciclo;
    
    @Column
    private Date fecha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", anio=" + anio + ", ciclo=" + ciclo + ", fecha=" + fecha + '}';
    }

    public Inscripcion() {
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, Integer anio, String ciclo, Date fecha) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.anio = anio;
        this.ciclo = ciclo;
        this.fecha = fecha;
    }

    public Inscripcion(Integer id) {
        this.id = id;
    }

    public Inscripcion(Integer id, Alumno alumno, Materia materia, Date fecha) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = fecha;
    }

    public Inscripcion(Date fecha) {
        this.fecha = fecha;
    }
}
