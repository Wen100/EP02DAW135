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
public class materiaBean implements Serializable{
    
    private Integer id;
    private String nombre;
    private String materiaId;
    @EJB 
    DataService servicio;
    
    private List<Materia> materiasList;

    @PostConstruct
    public void init(){
        materiasList = servicio.getMaterias();
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

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public DataService getServicio() {
        return servicio;
    }

    public void setServicio(DataService servicio) {
        this.servicio = servicio;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final materiaBean other = (materiaBean) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "materiaBeam{" + "id=" + id + ", nombre=" + nombre + ", materiaId=" + materiaId + '}';
    }
    
}
