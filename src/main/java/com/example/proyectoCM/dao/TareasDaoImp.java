package com.example.proyectoCM.dao;

import com.example.proyectoCM.Tarea;
import com.example.proyectoCM.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TareasDaoImp implements TareasDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void eliminarTarea(int id) {

    }

    @Override
    public List<Tarea> getTareas(Usuario usuario) {
        return null;
    }

    @Override
    public void agregarTarea(Tarea tarea) {

    }

  /*  @Override
    @Transactional
    public List<Tarea> getTareas(Usuario nombreUsuario) {
        String jpql = "SELECT t FROM Tarea t WHERE t.usuario = :nombreUsuario";
        TypedQuery<Tarea> query = entityManager.createQuery(jpql, Tarea.class)
                .setParameter("nombreUsuario", nombreUsuario);
        return query.getResultList();
    }




    @Override
    public void agregarTarea(Tarea tarea) {
        entityManager.merge(tarea);
    }*/
}
