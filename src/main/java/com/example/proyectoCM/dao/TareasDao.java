package com.example.proyectoCM.dao;

import com.example.proyectoCM.Tarea;
import com.example.proyectoCM.Usuario;

import java.util.List;

public interface TareasDao {

    void eliminarTarea(int id);

    List<Tarea> getTareas(Usuario usuario);

    void agregarTarea(Tarea tarea);
}
