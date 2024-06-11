/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ep2daw.appweb.negocio;

import com.ep2daw.appweb.entidades.Alumno;
import com.ep2daw.appweb.entidades.Inscripcion;
import com.ep2daw.appweb.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class DataService{
    
    @PersistenceContext(unitName="pu")
    EntityManager entityManager;
    
    private Alumno alumno = new Alumno();
    private Materia materia = new Materia();
    
    // Alumno
    
    public List<Alumno> getAlumnos(){
        
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id ASC");
        
        List<Alumno> alumnos = query.getResultList();
        
        return alumnos;
    }
    
    public Alumno getAlumno(Integer id){
        Alumno alumno = entityManager.find(Alumno.class, id);
        return alumno;
    }
    
    
    @Transactional
    public void saveAlumno(Alumno alumno){
        entityManager.persist(alumno);
    }
    
    @Transactional
    public void editAlumno(Alumno alumno){
        entityManager.merge(alumno);
    }
    
    @Transactional
    public void deleteAlumno(Alumno alumno){
        Alumno alumnoEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoEliminar);
    }
    
    // Materia
    
    public List<Materia> getMaterias(){
        
        Query query = entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id ASC");
        
        List<Materia> materia = query.getResultList();
        
        return materia;
    }
    
    public Materia getMateria(Integer id){
        Materia materia = entityManager.find(Materia.class, id);
        return materia;
    }
    
    
    @Transactional
    public void saveMateria(Materia materia){
        entityManager.persist(materia);
    }
    
    @Transactional
    public void editMateria(Materia materia){
        entityManager.merge(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia){
        Materia materiaEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaEliminar);
    }
    
    // Inscripcion
    
    public List<Inscripcion> getInscripciones(){
        
        Query query = entityManager.createQuery("SELECT i FROM Inscripcion i ORDER BY i.id ASC");
        
        List<Inscripcion> inscripcion = query.getResultList();
        
        return inscripcion;
    }
    
    @Transactional
    public void saveInscripcion(Inscripcion inscripcion){
        entityManager.persist(inscripcion);
    }
    
    @Transactional
    public void editInscripcion(Inscripcion inscripcion){
        entityManager.merge(inscripcion);
    }
    
    @Transactional
    public void deleteInscripcion(Inscripcion inscripcion){
        Inscripcion inscripcionEliminar = entityManager.find(Inscripcion.class, inscripcion.getId());
        entityManager.remove(inscripcionEliminar);
    }
}
