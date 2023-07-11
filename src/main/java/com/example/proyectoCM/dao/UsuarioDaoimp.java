package com.example.proyectoCM.dao;

import com.example.proyectoCM.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoimp implements UsuarioDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean verificarUsuario(Usuario usuario) {
        String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.contrasenna = :contrasenna";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("usuario", usuario.getUsuario())
                .setParameter("contrasenna", usuario.getContrasenna());

        List<Usuario> lista = query.getResultList();
        return !lista.isEmpty();
    }

    @Override
    public void eliminarUsuario(int id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String sql = "SELECT DISTINCT nombre, apellido, usuario,contrasenna,edad,correo FROM usuario";
        return entityManager.createNativeQuery(sql, Usuario.class).getResultList();
    }

    @Override
    @Transactional
    public List<Usuario> getUsuario(String id) {
        String jpql = "SELECT u FROM Usuario u WHERE u.usuario = :nombreUsuario";
        TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class)
                .setParameter("nombreUsuario", id);
        return query.getResultList();
    }





    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }


}
