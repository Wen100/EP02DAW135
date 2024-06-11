/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.entidades;

import com.ep2daw.appweb.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author josue
 */

@Named
@RequestScoped
public class alumnoBean implements Serializable{
    
    private Integer id;
    private String nombre;
    private String carnet;
    private String alumnoId;
    @EJB 
    DataService servicio;
    
    private List<Alumno> alumnosList;

    @PostConstruct
    public void init(){
        alumnosList = servicio.getAlumnos();
    }
    
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

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
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
        final alumnoBean other = (alumnoBean) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "alumnoBean{" + "id=" + id + ", nombre=" + nombre + ", carnet=" + carnet + '}';
    }
   
}
