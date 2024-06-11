/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author josue
 */

@Entity
@Table(name="alumnos")
public class Alumno implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumnos_id_seq")
    @SequenceGenerator(name="alumnos_id_seq", sequenceName="alumnos_id_seq", allocationSize=1)
    //Variables
    @Column(name="id")
    private Integer id;
    
    @Column(name="nombre")
    private String nombre;
    //Agregado
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="carnet")
    private String carnet;
    //Agregado
    @Column(name="carrera")
    private String carrera;
    
    //Set y Get

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    //Override

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
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
        final Alumno other = (Alumno) obj;
        return Objects.equals(this.id, other.id);
    }
    
    //Metodo to String
    

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", carnet=" + carnet + ", carrerra=" + carrera + '}';
    }
    
    //Constructores

    public Alumno(Integer id, String nombre, String apellido, String carnet, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carnet = carnet;
        this.carrera = carrera;
    }

    public Alumno(Integer id) {
        this.id = id;
    }
    
    public Alumno() {
        
    }

    
    
}
