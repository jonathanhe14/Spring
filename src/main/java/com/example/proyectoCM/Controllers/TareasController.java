package com.example.proyectoCM.Controllers;

import com.example.proyectoCM.Tarea;
import com.example.proyectoCM.Usuario;
import com.example.proyectoCM.dao.TareasDao;
import com.example.proyectoCM.dao.UsuarioDao;
import com.example.proyectoCM.dao.UsuarioDaoimp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Controller
public class TareasController {


    @Autowired
    private TareasDao tareasDao;


    /*@RequestMapping(value="/tareas/{nombreUsuario}")
    public List<Tarea> getUsuario(@PathVariable Usuario nombreUsuario) {
        return tareasDao.getTareas(nombreUsuario);
    }

    @RequestMapping(value="/agregarTarea", method = RequestMethod.POST)
    public void agregarTarea(@RequestBody Tarea tarea){
        tareasDao.agregarTarea(tarea);
    };*/
}
