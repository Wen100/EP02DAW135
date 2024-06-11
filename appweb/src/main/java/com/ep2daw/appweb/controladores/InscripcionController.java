/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.controladores;

import com.ep2daw.appweb.entidades.Alumno;
import com.ep2daw.appweb.entidades.Inscripcion;
import com.ep2daw.appweb.entidades.Materia;
import com.ep2daw.appweb.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Date;
import java.util.List;

/**
 *
 * @author josue
 */

@Named
@RequestScoped
public class InscripcionController {
     
    private List<Inscripcion> inscripcionesList;
     
    private Inscripcion inscripcion = new Inscripcion();
    
    private String materiaId;
    
    private String alumnoId;
    
    @EJB
    DataService servicio;
    
    @PostConstruct
    public void cargarInscripciones(){
        
        inscripcionesList = servicio.getInscripciones();
        this.inscripcion = new Inscripcion();
        inscripcion.setFecha(new Date());
    }
    
    public void guardarInscripcion(){
        Alumno alumno = servicio.getAlumno(Integer.parseInt(alumnoId));
        Materia materia = servicio.getMateria(Integer.parseInt(materiaId));
        this.inscripcion.setAlumno(alumno);
        this.inscripcion.setMateria(materia);
        this.inscripcion.setAnio(inscripcion.getAnio());
        servicio.saveInscripcion(inscripcion);
        cargarInscripciones();
    }
    
    public void llenarFormEditar(Inscripcion inscripcion){
        this.inscripcion.setAlumno(inscripcion.getAlumno());
        this.inscripcion.setMateria(inscripcion.getMateria());
        this.inscripcion.setAnio(inscripcion.getAnio());
        this.inscripcion.setCiclo(inscripcion.getCiclo());
    }
    
    public void eliminarInscripcion(Inscripcion inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }

    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }

    public void setInscripcionesList(List<Inscripcion> inscripcionesList) {
        this.inscripcionesList = inscripcionesList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public String getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(String alumnoId) {
        this.alumnoId = alumnoId;
    }


    
}
