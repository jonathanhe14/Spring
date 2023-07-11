package com.example.proyectoCM.dao;

import com.example.proyectoCM.Usuario;

import java.util.List;

public interface UsuarioDao {

    boolean verificarUsuario(Usuario usuario);

    void eliminarUsuario(int id);

    List<Usuario> getUsuarios();
    List<Usuario> getUsuario(String id);

    void registrar(Usuario usuario);
}
